package xyz.sandersonsa.service;

import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.CandidatoComissao;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.CandidatoComissaoRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class CandidatoComissaoService {

    private static Logger logger = LoggerFactory.getLogger(CandidatoComissaoService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    CandidatoComissaoRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){        

        if(OperationEnum.INSERT.getDescricao().equals(operation)) {            
            try {
                repository.persistAndFlush(salvar(bodyMap));
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


    private CandidatoComissao atualizar(CandidatoComissao objeto, Map bodyMap){
        return preencher(objeto, bodyMap);
    }

    private CandidatoComissao salvar(Map bodyMap){
        CandidatoComissao objeto = new CandidatoComissao();
        objeto.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(objeto, bodyMap);
    }

    private CandidatoComissao preencher(CandidatoComissao objeto, Map bodyMap){
        objeto.setIdCandidato(Integer.parseInt(bodyMap.get("fk_candidato").toString()));
        objeto.setIdComissao(Integer.parseInt(bodyMap.get("fk_comissao").toString()));
        objeto.setDataCriacao(utilsService.convertToDate(bodyMap.get("created_at").toString()));
        if(Objects.nonNull(bodyMap.get("updated_at")))
            objeto.setDataAtualizacao(utilsService.convertToDate(bodyMap.get("updated_at").toString()));
        if(Objects.nonNull(bodyMap.get("ativo")))
            objeto.setAtivo(Boolean.parseBoolean(bodyMap.get("ativo").toString()));
        if(Objects.nonNull(bodyMap.get("fk_motivo_validacao")))
            objeto.setIdMotivoValidacao(Integer.parseInt(bodyMap.get("fk_motivo_validacao").toString()));
        if(Objects.nonNull(bodyMap.get("fk_capacete")))
            objeto.setIdCapacete(Integer.parseInt(bodyMap.get("fk_capacete").toString()));
        if(Objects.nonNull(bodyMap.get("categoria")))
            objeto.setCategoria(bodyMap.get("categoria").toString());
        return objeto;
    }

}