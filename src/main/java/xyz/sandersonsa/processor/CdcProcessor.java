package xyz.sandersonsa.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.debezium.DebeziumConstants;
import org.apache.kafka.common.quota.ClientQuotaAlteration.Op;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.Struct;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.Candidato;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.model.TabelasEnum;
import xyz.sandersonsa.repository.CandidatoRepository;
import xyz.sandersonsa.service.CandidatoService;
import xyz.sandersonsa.service.FilaService;

@ApplicationScoped
@Named("cdcProcessor")
public class CdcProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(CdcProcessor.class);

    @Inject
    FilaService filaService;

    @Inject
    CandidatoService candidatoService;

    @Transactional
    public void process(Exchange exchange) throws Exception {        

        Message in = exchange.getIn();
        
        String operation = in.getHeader(DebeziumConstants.HEADER_OPERATION, String.class);
        String chavePrimaria =  in.getHeader(DebeziumConstants.HEADER_KEY, Struct.class).getWithoutDefault("id").toString();
        String table = in.getHeader("table", String.class);
        
        // Map -- Null quando o evento é delete
        Map bodyMap = exchange.getIn().getBody(Map.class);
        
        if(TabelasEnum.CANDIDATOS.getDescricao().equals(table)) {            
            candidatoService.processarCandidato(bodyMap, operation, chavePrimaria);        
        }

        else if(TabelasEnum.CANDIDATOS_COMISSAO.getDescricao().equals(table)) {
            logger.info(" ## TIPO - {} ## ", TabelasEnum.CANDIDATOS_COMISSAO);
        }

        else if(TabelasEnum.JULGAMENTO_PROCESSSO.getDescricao().equals(table)) {
            logger.info(" ## TIPO - {} ## ", TabelasEnum.JULGAMENTO_PROCESSSO);
        }

        else if(TabelasEnum.DOCUMENTO_ANEXO.getDescricao().equals(table)) {
            logger.info(" ## TIPO - {} ## ", TabelasEnum.DOCUMENTO_ANEXO);
        }

        else if(TabelasEnum.CANDIDATO_RESTRICAO.getDescricao().equals(table)) {
            logger.info(" ## TIPO - {} ## ", TabelasEnum.CANDIDATO_RESTRICAO);
        }

        else if(TabelasEnum.FILA_CODE.getDescricao().equals(table)) {
            logger.info(" ## TIPO - {} ## ", TabelasEnum.FILA_CODE);
        }

        else if(TabelasEnum.FILA_ACCESS.getDescricao().equals(table)) {
            logger.info(" ## TIPO - {} ## ", TabelasEnum.FILA_ACCESS);
        }

        else if(TabelasEnum.FILA.getDescricao().equals(table)) {
            logger.info(" ## TIPO - {} ## ", TabelasEnum.FILA);
            processarFila(in.getBody(String.class));
        }


    }

    private void processarFila(String body) {
        filaService.processarFila(body);
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
