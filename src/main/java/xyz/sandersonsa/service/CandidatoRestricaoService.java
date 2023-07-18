package xyz.sandersonsa.service;

import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.CandidatoRestricao;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.CandidatoRestricaoRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class CandidatoRestricaoService {

    private static Logger logger = LoggerFactory.getLogger(CandidatoRestricaoService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    CandidatoRestricaoRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){
        logger.info(" ## PROCESSAR JULGAMENTO PROCESSO ## - {}", operation);

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


    private CandidatoRestricao atualizar(CandidatoRestricao objeto, Map bodyMap){
        return preencher(bodyMap, objeto);
    }

    private CandidatoRestricao salvar(Map bodyMap){
        CandidatoRestricao objeto = new CandidatoRestricao();
        objeto.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(bodyMap, objeto);
    }

    private CandidatoRestricao preencher(Map bodyMap, CandidatoRestricao objeto) {        
        if(Objects.nonNull(bodyMap.get("candidato_comissao_id")))
            objeto.setIdCandidatoComissao(Integer.parseInt(bodyMap.get("candidato_comissao_id").toString()));
        if(Objects.nonNull(bodyMap.get("restricao")))
            objeto.setRestricao(bodyMap.get("restricao").toString());
        return objeto;
    }

}