package xyz.sandersonsa.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.debezium.DebeziumConstants;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.Struct;
import org.springframework.scheduling.annotation.Scheduled;

import io.debezium.pipeline.signal.Log;
import io.debezium.time.Timestamp;
import net.bytebuddy.asm.Advice.Local;
import xyz.sandersonsa.model.Orders;
import xyz.sandersonsa.service.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;

public class PostgresCDCRoute extends RouteBuilder {

       // Service to insert the movie data into Movie and Outbox tables
       @Inject
       OrderService orderService;

       String DBZ_SETTINGS = "debezium-postgres:dbz-camel?offsetStorageFileName={{app.cdc.dbz.offset.file}}" +
                     "&databaseDbname={{app.cdc.db.name}}" +
                     "&databaseHostname={{app.cdc.db.host}}" +
                     "&databasePort={{app.cdc.db.port}}" +
                     "&databaseUser={{app.cdc.db.user}}" +
                     "&databasePassword={{app.cdc.db.password}}" +
                     "&databaseServerName={{app.cdc.dbz.dbservername}}" +
                     "&databaseHistoryFileFilename={{app.cdc.dbz.dbhistoryfile}}" +
                     "&schemaIncludeList={{app.cdc.dbz.schemaincludelist}}" +
                     "&tableIncludeList={{app.cdc.dbz.tableincludelist}}" +
                     "&timePrecisionMode=connect" +
                     "&pluginName=pgoutput";

       @Override
       public void configure() throws Exception {

              from(DBZ_SETTINGS)
                     // Event received from Debezium : Struct{orderid=10,orderdate=2023-05-17T03:00:00Z,sku=abc,description=sanderson sa,amount=1000.0}
                     .log("\n\n----- ----- ----- ----- ----- ----- ----- ")
                     .log("Event received from Debezium : ${body}")
                     .log(" identificador :: ${headers.CamelDebeziumIdentifier}")
                     // c= create, u= update, d= delete, r= snapshot
                     .log(" operation :: ${headers.CamelDebeziumOperation}")
                     // .log(" timestamp :: ${headers.CamelDebeziumTimestamp}")
                     // .log(" transactionId :: ${headers.CamelDebeziumTransactionId}")
                     // .log(" sourceDataCollection :: ${headers.CamelDebeziumSourceDataCollection}")
                     // .log(" sourceDataSchema :: ${headers.CamelDebeziumSourceDataSchema}")
                     // .log(" sourceDataVersion :: ${headers.CamelDebeziumSourceDataVersion}")
                     // .log(" sourceDataPartition :: ${headers.CamelDebeziumSourceDataPartition}")
                     // .log(" sourceDataOffset :: ${headers.CamelDebeziumSourceDataOffset}")
                     // .log(" sourceDataSnapshot :: ${headers.CamelDebeziumSourceDataSnapshot}")
                     .log(" sourceDataSnapshotCompleted :: ${headers.CamelDebeziumSourceMetadata}")
                     .log(" base :: ${headers.CamelDebeziumSourceMetadata[db]}")
                     .log(" tabela :: ${headers.CamelDebeziumSourceMetadata[table]}")
                     .log(LoggingLevel.INFO, " ## Message body: ${body}")
                     .process(
                            exchange -> {
                                   Message in = exchange.getIn();

                                   final Map value = in.getHeader(DebeziumConstants.HEADER_BEFORE, Map.class);
                                   final Map valueddl = in.getHeader(DebeziumConstants.HEADER_DDL_SQL, Map.class);
                                   log.info(" ## Value :: {}", value);
                                   log.info(" ## Value DDL :: {}", valueddl);

                                   final Struct body = in.getBody(Struct.class);
                                   
                                   //Map -- Null quando o evento é delete
                                   Map bodyMap = exchange.getIn().getBody(Map.class);
                                   if(Objects.nonNull(bodyMap)){
                                          log.info(" ## Body Map :: {}", bodyMap);
                                          //log.info(" ## orderdate :: {}", bodyMap.get("orderdate"));

                                          double amount = Double.parseDouble(bodyMap.get("amount").toString());
                                          Orders order = new Orders(
                                                 bodyMap.get("orderid").toString(),
                                                 convertToDate(bodyMap.get("orderdate").toString()), //Fri Nov 25 21:00:00 BRT 2022
                                                 bodyMap.get("sku").toString(),
                                                 bodyMap.get("description").toString(),
                                                 amount
                                          );

                                          log.info(" ## Order :: {}", order);
                                          orderService.inserOrder(order);       
                                   }
                                                                      
                                   if(body == null){
                                          log.info(" ## Body is null");
                                          return;
                                   }                                   
                                   Schema schema = body.schema();                                   
                                   log.info(" ## Body :: {}", body);
                                   log.info(" ## Schema :: {}", schema);
                                   log.info(" ## Schema fields :: {}", schema.fields());                                   
                                   log.info(" ## Schema fields size :: {}", schema.fields().size());
                                   log.info(" ## Campo name :: {}", schema.field("name"));
                                   log.info(" # Data :: {}", body.get("orderdate"));                                   
                                   
                            })

                     //process the message
                     // .process(
                     //        exchange -> {
                     //               Message in = exchange.getIn();
                     //               final Struct body = in.getBody(Struct.class);
                     //               if(body == null){
                     //                      log.info(" ## Body is null");
                     //                      return;
                     //               }
                     //               CustomerOrder order = new CustomerOrder(
                     //                      body.getString("orderid"),
                     //                      body.get("orderdate").toString(),
                     //                      body.getString("sku"),
                     //                      body.getString("description"),
                     //                      body.getFloat64("amount"));
                     //               in.setBody(order);
                     //        })
                     // .log("Captured order: ${body}")
                     
                     // .setProperty("orderDetail", simple("${body}"))
                     // .setProperty("orderId", simple("${body.orderId}"))
                     // .to("sql:classpath:sql/customer.sql")
                     // .log("SQL Query from customer table: ${body}")
                     // .process(
                     //        exchange -> {
                     //               CustomerOrder order = (CustomerOrder) exchange.getProperty("orderDetail");
                     //               Message in = exchange.getIn();
                     //               String custname = (String) ((Map) ((List) in.getBody()).get(0)).get("name");
                     //               Integer custId = (Integer) ((Map) ((List) in.getBody()).get(0)).get("custId");
                     //               order.setCustName(custname);
                     //               order.setCustId(custId);
                     //               in.setBody(order);
                     //        })
                     // .log("Enriched Order: ${body}")
                     // .marshal().json()
                     // .log("Transform Order Object to Json: ${body}")
                     // .to("file:{{output.dir}}?fileName={{output.filename}}&appendChars=\n&fileExist=Append")
                     // .log("JSON data saved into file.")
              ;

       }

       private LocalDateTime convertToLocalDateTime(String date) {
              //Fri Nov 25 21:00:00 BRT 2022
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
              // String date = "Tuesday, Aug 16, 2016 12:10:56 PM";
              LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
              System.out.println(localDateTime);
              System.out.println(formatter.format(localDateTime));
              return localDateTime;
       }

       private Date convertToDate(String str) {
              SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
              // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);              
              try {
                     return formatter.parse(str);
              } catch (ParseException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
              return null;
       }
}

