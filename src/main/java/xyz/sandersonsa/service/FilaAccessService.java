package xyz.sandersonsa.service;

import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.FilaAccessToken;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.FilaAcessRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class FilaAccessService {

    private static Logger logger = LoggerFactory.getLogger(FilaAccessService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    FilaAcessRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){        

        if(OperationEnum.INSERT.getDescricao().equals(operation)) {            
            repository.persistAndFlush(salvar(bodyMap));

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


    private FilaAccessToken atualizar(FilaAccessToken objeto, Map bodyMap){
        return preencher(bodyMap, objeto);
    }

    private FilaAccessToken salvar(Map bodyMap){
        FilaAccessToken objeto = new FilaAccessToken();
        objeto.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(bodyMap, objeto);
    }

    private FilaAccessToken preencher(Map bodyMap, FilaAccessToken objeto) {        
        objeto.setAccessToken(bodyMap.get("access_token").toString());
        //date
        if(Objects.nonNull(bodyMap.get("expiration_access_token")))
            objeto.setExpirationAccessToken(utilsService.convertToDate(bodyMap.get("expiration_access_token").toString()));
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