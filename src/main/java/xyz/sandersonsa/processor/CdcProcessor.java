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

import io.debezium.document.Document;
import xyz.sandersonsa.model.TabelasEnum;
import xyz.sandersonsa.service.CandidatoComissaoService;
import xyz.sandersonsa.service.CandidatoRestricaoService;
import xyz.sandersonsa.service.CandidatoService;
import xyz.sandersonsa.service.DocumentoAnexoService;
import xyz.sandersonsa.service.FilaAccessService;
import xyz.sandersonsa.service.FilaCodeService;
import xyz.sandersonsa.service.FilaService;
import xyz.sandersonsa.service.JulgamentoProcessoService;

@ApplicationScoped
@Named("cdcProcessor")
public class CdcProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(CdcProcessor.class);

    @Inject
    CandidatoService candidatoService;

    @Inject
    CandidatoComissaoService candidatoComissaoService;

    @Inject
    JulgamentoProcessoService julgamentoProcessoService;

    @Inject
    DocumentoAnexoService documentoAnexoService;

    @Inject
    CandidatoRestricaoService candidatoRestricaoService;

    @Inject
    FilaCodeService filaCodeService;

    @Inject
    FilaAccessService filaAccessService;

    @Inject
    FilaService filaService;

    private String LOG_INFO = " ## TIPO - {} ## ";
    
    public void process(Exchange exchange) throws Exception {        

        Message in = exchange.getIn();
        
        String operation = in.getHeader(DebeziumConstants.HEADER_OPERATION, String.class);
        String chavePrimaria =  in.getHeader(DebeziumConstants.HEADER_KEY, Struct.class).getWithoutDefault("id").toString();
        String table = in.getHeader("table", String.class);
        
        // Map -- Null quando o evento é delete
        Map bodyMap = exchange.getIn().getBody(Map.class);
        
        if(TabelasEnum.CANDIDATOS.getDescricao().equals(table)) {            
            //logger.info(LOG_INFO, TabelasEnum.CANDIDATOS);
            candidatoService.processar(bodyMap, operation, chavePrimaria);        
        }

        else if(TabelasEnum.CANDIDATOS_COMISSAO.getDescricao().equals(table)) {
            //logger.info(LOG_INFO, TabelasEnum.CANDIDATOS_COMISSAO);
            candidatoComissaoService.processar(bodyMap, operation, chavePrimaria);
        }

        else if(TabelasEnum.JULGAMENTO_PROCESSSO.getDescricao().equals(table)) {
            //logger.info(LOG_INFO, TabelasEnum.JULGAMENTO_PROCESSSO);
            julgamentoProcessoService.processar(bodyMap, operation, chavePrimaria);            
        }

        else if(TabelasEnum.DOCUMENTO_ANEXO.getDescricao().equals(table)) {
            //logger.info(LOG_INFO, TabelasEnum.DOCUMENTO_ANEXO);
            documentoAnexoService.processar(bodyMap, operation, chavePrimaria);
        }

        else if(TabelasEnum.CANDIDATO_RESTRICAO.getDescricao().equals(table)) {
            //logger.info(LOG_INFO, TabelasEnum.CANDIDATO_RESTRICAO);
            candidatoRestricaoService.processar(bodyMap, operation, chavePrimaria);
        }

        else if(TabelasEnum.FILA_CODE.getDescricao().equals(table)) {
            //logger.info(LOG_INFO, TabelasEnum.FILA_CODE);
            filaCodeService.processar(bodyMap, operation, chavePrimaria);
        }

        else if(TabelasEnum.FILA_ACCESS.getDescricao().equals(table)) {
            //logger.info(LOG_INFO, TabelasEnum.FILA_ACCESS);
            filaAccessService.processar(bodyMap, operation, chavePrimaria);
        }

        else if(TabelasEnum.FILA.getDescricao().equals(table)) {
            //logger.info(LOG_INFO, TabelasEnum.FILA);
            filaService.processar(bodyMap, operation, chavePrimaria);            
        }


    }

}
