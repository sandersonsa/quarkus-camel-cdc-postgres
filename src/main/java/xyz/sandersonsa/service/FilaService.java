package xyz.sandersonsa.service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.Fila;
import xyz.sandersonsa.model.FilaCodeKeys;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.FilaRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class FilaService {

    private static Logger logger = LoggerFactory.getLogger(FilaService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    FilaRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){

        if(OperationEnum.INSERT.getDescricao().equals(operation)) {            
            try {
                Fila obj = salvar(bodyMap);
                repository.persistAndFlush(obj);
                Optional<Fila> objBD = repository.findByIdOptional(obj.getId());
                if(objBD.isPresent()){
                    logger.info(" ## Fila salvo com sucesso ## ");
                }
            } catch (javax.persistence.PersistenceException e) {
                logger.error("Erro ao salvar registro :: {}", e.getMessage());
            }

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


    private Fila atualizar(Fila objeto, Map bodyMap){
        return preencher(objeto, bodyMap);
    }

    private Fila salvar(Map bodyMap){
        Fila objeto = new Fila();
        objeto.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(objeto, bodyMap);
    }

    private Fila preencher(Fila objeto, Map bodyMap){
        if(Objects.nonNull(bodyMap.get("code")))
            objeto.setCode(bodyMap.get("code").toString());
        //date
        if(Objects.nonNull(bodyMap.get("created_at")))
            objeto.setCreatedAt(utilsService.convertToDate(bodyMap.get("created_at").toString()));
        if(Objects.nonNull(bodyMap.get("updated_at")))
            objeto.setUpdatedAt(utilsService.convertToDate(bodyMap.get("updated_at").toString()));
        
        objeto.setAtivo(Boolean.parseBoolean(bodyMap.get("ativo").toString()));
        if(Objects.nonNull(bodyMap.get("access_token")))
            objeto.setAccessToken(bodyMap.get("access_token").toString());        
        return objeto;
    }

}