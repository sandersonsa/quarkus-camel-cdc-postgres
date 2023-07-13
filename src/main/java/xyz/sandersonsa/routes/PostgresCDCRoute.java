package xyz.sandersonsa.routes;

import org.apache.camel.builder.RouteBuilder;

public class PostgresCDCRoute extends RouteBuilder {


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
                     // "&snapshotMode=never" +
                     "&pluginName=pgoutput";

       @Override
       public void configure() throws Exception {

              from(DBZ_SETTINGS)                     
                     .log("\n\n----- ----- ----- ----- ----- ----- ----- ")
                     .log(" ## Event received from Debezium : ${body}")
                     .log(" ## Source DataSnapshot Completed :: ${headers.CamelDebeziumSourceMetadata}")                     
                     .setHeader("table", simple("${headers.CamelDebeziumSourceMetadata[db]}.${headers.CamelDebeziumSourceMetadata[table]}"))
                     .process("cdcProcessor")
              ;
       }
}