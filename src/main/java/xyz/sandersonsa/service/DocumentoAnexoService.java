package xyz.sandersonsa.service;

import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.DocumentoAnexo;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.DocumentoAnexoRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class DocumentoAnexoService {

    private static Logger logger = LoggerFactory.getLogger(DocumentoAnexoService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    DocumentoAnexoRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){
        logger.info(" ## PROCESSAR Documento Anexo ## - {}", operation);

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


    private DocumentoAnexo atualizar(DocumentoAnexo objeto, Map bodyMap){
        return preencher(bodyMap, objeto);
    }

    private DocumentoAnexo salvar(Map bodyMap){
        DocumentoAnexo objeto = new DocumentoAnexo();
        objeto.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(bodyMap, objeto);
    }

    private DocumentoAnexo preencher(Map bodyMap, DocumentoAnexo objeto) {        
        objeto.setIdCandidatoComissao(Integer.parseInt(bodyMap.get("fk_candidato_comissao").toString()));
        objeto.setIdTipoDocumento(Integer.parseInt(bodyMap.get("fk_tipo_documento").toString()));
        objeto.setCreatedAt(utilsService.convertToDate(bodyMap.get("created_at").toString()));
        if(Objects.nonNull(bodyMap.get("deleted_at")))
            objeto.setDeletedAt(utilsService.convertToDate(bodyMap.get("deleted_at").toString()));
        if(Objects.nonNull(bodyMap.get("updated_at")))
            objeto.setUpdatedAt(utilsService.convertToDate(bodyMap.get("updated_at").toString()));
        if(Objects.nonNull(bodyMap.get("ativo")))        
            objeto.setAtivo(Boolean.parseBoolean(bodyMap.get("ativo").toString()));        
        if(Objects.nonNull(bodyMap.get("hash_storage")))
            objeto.setHashStorage(bodyMap.get("hash_storage").toString());
        if(Objects.nonNull(bodyMap.get("avaliador")))
            objeto.setAvaliador(bodyMap.get("avaliador").toString());
        objeto.setDocumentoBase64(bodyMap.get("documento_base64").toString());
        return objeto;
    }

}