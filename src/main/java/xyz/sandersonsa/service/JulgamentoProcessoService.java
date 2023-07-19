package xyz.sandersonsa.service;

import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.JulgamentoProcesso;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.JulgamentoProcessoRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class JulgamentoProcessoService {

    private static Logger logger = LoggerFactory.getLogger(JulgamentoProcessoService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    JulgamentoProcessoRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){

        if(OperationEnum.INSERT.getDescricao().equals(operation)) {            
            repository.persist(salvar(bodyMap));

        }
        else if(OperationEnum.UPDATE.getDescricao().equals(operation)) {            
            final var id = Long.parseLong(chavePrimaria);
            var savedOpt = repository.findByIdOptional(id);
            if (savedOpt.isEmpty()) {
                return;
            }            
            atualizar(savedOpt.get(), bodyMap);
            repository.persist(savedOpt.get());  
        }
        else if(OperationEnum.DELETE.getDescricao().equals(operation)) {
            final var id = Long.parseLong(chavePrimaria);
            var savedOpt = repository.findByIdOptional(id);
            if (savedOpt.isEmpty()) {
                return;
            }
            repository.delete(savedOpt.get());
        }
    }


    private JulgamentoProcesso atualizar(JulgamentoProcesso objeto, Map bodyMap){
        return preencher(bodyMap, objeto);
    }

    private JulgamentoProcesso salvar(Map bodyMap){
        JulgamentoProcesso objeto = new JulgamentoProcesso();
        objeto.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(bodyMap, objeto);
    }

    private JulgamentoProcesso preencher(Map bodyMap, JulgamentoProcesso objeto) {  
        logger.info(" ## Preenchendo objeto JulgamentoProcesso ##");      
        objeto.setIdCandidatoComissao(Integer.parseInt(bodyMap.get("fk_candidato_comissao").toString()));
        objeto.setIdStatusValidacao(Integer.parseInt(bodyMap.get("fk_status_validacao").toString()));
        objeto.setCreatedAt(utilsService.convertToDate(bodyMap.get("created_at").toString()));
        if(Objects.nonNull(bodyMap.get("updated_at")))
            objeto.setUpdatedAt(utilsService.convertToDate(bodyMap.get("updated_at").toString()));
        objeto.setAtivo(Boolean.parseBoolean(bodyMap.get("ativo").toString()));        
        if(Objects.nonNull(bodyMap.get("observacao")))
            objeto.setObservacao(bodyMap.get("observacao").toString());
        if(Objects.nonNull(bodyMap.get("operador")))
            objeto.setOperador(bodyMap.get("operador").toString());
        return objeto;
    }

}