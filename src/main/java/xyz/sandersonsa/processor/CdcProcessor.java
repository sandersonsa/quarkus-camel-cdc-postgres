package xyz.sandersonsa.processor;

import java.util.Map;
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

import xyz.sandersonsa.model.TabelasEnum;
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

    private String LOG_INFO = " ## TIPO - {} ## ";

    @Transactional
    public void process(Exchange exchange) throws Exception {        

        Message in = exchange.getIn();
        
        String operation = in.getHeader(DebeziumConstants.HEADER_OPERATION, String.class);
        String chavePrimaria =  in.getHeader(DebeziumConstants.HEADER_KEY, Struct.class).getWithoutDefault("id").toString();
        String table = in.getHeader("table", String.class);
        
        // Map -- Null quando o evento é delete
        Map bodyMap = exchange.getIn().getBody(Map.class);
        
        if(TabelasEnum.CANDIDATOS.getDescricao().equals(table)) {            
            candidatoService.processar(bodyMap, operation, chavePrimaria);        
        }

        else if(TabelasEnum.CANDIDATOS_COMISSAO.getDescricao().equals(table)) {
            logger.info(LOG_INFO, TabelasEnum.CANDIDATOS_COMISSAO);
        }

        else if(TabelasEnum.JULGAMENTO_PROCESSSO.getDescricao().equals(table)) {
            logger.info(LOG_INFO, TabelasEnum.JULGAMENTO_PROCESSSO);
        }

        else if(TabelasEnum.DOCUMENTO_ANEXO.getDescricao().equals(table)) {
            logger.info(LOG_INFO, TabelasEnum.DOCUMENTO_ANEXO);
        }

        else if(TabelasEnum.CANDIDATO_RESTRICAO.getDescricao().equals(table)) {
            logger.info(LOG_INFO, TabelasEnum.CANDIDATO_RESTRICAO);
        }

        else if(TabelasEnum.FILA_CODE.getDescricao().equals(table)) {
            logger.info(LOG_INFO, TabelasEnum.FILA_CODE);
        }

        else if(TabelasEnum.FILA_ACCESS.getDescricao().equals(table)) {
            logger.info(LOG_INFO, TabelasEnum.FILA_ACCESS);
        }

        else if(TabelasEnum.FILA.getDescricao().equals(table)) {
            logger.info(LOG_INFO, TabelasEnum.FILA);            
        }


    }

}
