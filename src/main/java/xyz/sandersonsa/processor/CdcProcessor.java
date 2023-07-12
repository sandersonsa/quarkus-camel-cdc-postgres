package xyz.sandersonsa.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.debezium.DebeziumConstants;
import org.apache.kafka.connect.data.Struct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.repository.CandidatoRepository;

@ApplicationScoped
@Named("cdcProcessor")
public class CdcProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(CdcProcessor.class);

    @Inject
    CandidatoRepository candidatoRepository;

    // c= create, u= update, d= delete, r= snapshot
    private final String OPERATION_INSERT = "c";
    private final String OPERATION_UPDATE = "u";
    private final String OPERATION_DELETE = "d";

    @Transactional
    public void process(Exchange exchange) throws Exception {        

        Message in = exchange.getIn();
        
        String operation = in.getHeader(DebeziumConstants.HEADER_OPERATION, String.class);
        String table = in.getHeader("table", String.class);
        
        logger.info(" ## OPERATION :: {} - {}", operation, table);
        
        final Struct body = in.getBody(Struct.class);
        
        if(OPERATION_INSERT.equals(operation)) {
            logger.info(" ## OPERATION INSERT => {}", body);
        }

        if(OPERATION_UPDATE.equals(operation)) {
            logger.info(" ## OPERATION_UPDATE => {}", body);
        }

        if(OPERATION_DELETE.equals(operation)) {
            logger.info(" ## OPERATION_DELETE => {}", body);
        }

    }

    private LocalDateTime convertToLocalDateTime(String date) {
        // Fri Nov 25 21:00:00 BRT 2022
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        return LocalDateTime.parse(date, formatter);        
    }

    private Date convertToDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd
        // HH:mm:ss zzz yyyy", Locale.US);
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
