package xyz.sandersonsa.service;

import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.CandidatoComissao;
import xyz.sandersonsa.model.FilaCodeKeys;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.CandidatoComissaoRepository;
import xyz.sandersonsa.repository.FilaCodeRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class FilaCodeService {

    private static Logger logger = LoggerFactory.getLogger(FilaCodeService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    FilaCodeRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){
        logger.info(" ## PROCESSAR CANDIDATO COMISSAO ## - {}", operation);

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


    private FilaCodeKeys atualizar(FilaCodeKeys objeto, Map bodyMap){
        return preencher(objeto, bodyMap);
    }

    private FilaCodeKeys salvar(Map bodyMap){
        FilaCodeKeys objeto = new FilaCodeKeys();
        objeto.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(objeto, bodyMap);
    }

    private FilaCodeKeys preencher(FilaCodeKeys objeto, Map bodyMap){
        objeto.setCode(bodyMap.get("code").toString());
        //date
        if(Objects.nonNull(bodyMap.get("expiration_code")))
            objeto.setExpirationCode(utilsService.convertToDate(bodyMap.get("expiration_code").toString()));
        if(Objects.nonNull(bodyMap.get("created_at")))
            objeto.setCreatedAt(utilsService.convertToDate(bodyMap.get("created_at").toString()));
        if(Objects.nonNull(bodyMap.get("updated_at")))
            objeto.setUpdatedAt(utilsService.convertToDate(bodyMap.get("updated_at").toString()));
        if(Objects.nonNull(bodyMap.get("ativo")))
            objeto.setAtivo(Boolean.parseBoolean(bodyMap.get("ativo").toString()));
        if(Objects.nonNull(bodyMap.get("source_ip")))
            objeto.setSourceIp(bodyMap.get("source_ip").toString());
        if(Objects.nonNull(bodyMap.get("user_agent")))
            objeto.setUserAgent(bodyMap.get("user_agent").toString());
        return objeto;
    }

}