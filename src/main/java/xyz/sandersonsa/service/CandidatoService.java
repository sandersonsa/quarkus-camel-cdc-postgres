package xyz.sandersonsa.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.Candidato;
import xyz.sandersonsa.model.CandidatoRestricao;
import xyz.sandersonsa.model.OperationEnum;
import xyz.sandersonsa.repository.CandidatoRepository;
import xyz.sandersonsa.utils.UtilsService;

@ApplicationScoped
public class CandidatoService {

    private static Logger logger = LoggerFactory.getLogger(CandidatoService.class);

    @Inject
    UtilsService utilsService;

    @Inject
    CandidatoRepository repository;

    @Transactional
    public void processar(Map bodyMap, String operation, String chavePrimaria){        

        if(OperationEnum.INSERT.getDescricao().equals(operation)) {            
            try {
                Candidato obj = salvar(bodyMap);                
                repository.persistAndFlush(obj);
                Optional<Candidato> objBD = repository.findByIdOptional(obj.getId());
                if(objBD.isPresent()){
                    logger.info(" ## Candidato salvo com sucesso ## ");
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

    private Candidato atualizar(Candidato candidato, Map bodyMap){
        return preencher(candidato, bodyMap);
    }

    private Candidato salvar(Map bodyMap){
        Candidato candidato = new Candidato();
        candidato.setId(Long.parseLong(bodyMap.get("id").toString()));
        return preencher(candidato, bodyMap);
    }

    private Candidato preencher(Candidato candidato, Map bodyMap){        
        candidato.setCpf(bodyMap.get("cpf").toString());
        candidato.setDataNascimento(utilsService.convertToDate(bodyMap.get("data_nascimento").toString()));
        candidato.setNome(bodyMap.get("nome").toString());
        candidato.setNomeMae(bodyMap.get("nome_mae").toString());
        if(Objects.nonNull(bodyMap.get("nome_pai")))
            candidato.setNomePai(bodyMap.get("nome_pai").toString());
        candidato.setSexo(bodyMap.get("sexo").toString());
        candidato.setCep(bodyMap.get("cep").toString());
        candidato.setLogradouro(bodyMap.get("logradouro").toString());
        if(Objects.nonNull(bodyMap.get("numero")))
            candidato.setNumero(bodyMap.get("numero").toString());
        if(Objects.nonNull(bodyMap.get("bairro")))
            candidato.setBairro(bodyMap.get("bairro").toString());
        if(Objects.nonNull(bodyMap.get("complemento")))
            candidato.setComplemento(bodyMap.get("complemento").toString());
        candidato.setUfEndereco(bodyMap.get("uf_endereco").toString());
        if(Objects.nonNull(bodyMap.get("ddd_residencial")))
            candidato.setDddResidencial(bodyMap.get("ddd_residencial").toString());
        if(Objects.nonNull(bodyMap.get("telefone_residencial")))
            candidato.setTelefoneResidencial(bodyMap.get("telefone_residencial").toString());
        if(Objects.nonNull(bodyMap.get("ddd_celular")))
            candidato.setDddCelular(bodyMap.get("ddd_celular").toString());
        if(Objects.nonNull(bodyMap.get("telefone_celular")))
            candidato.setTelefoneCelular(bodyMap.get("telefone_celular").toString());
        if(Objects.nonNull(bodyMap.get("num_documento")))
            candidato.setNumDocumento(bodyMap.get("num_documento").toString());
        if(Objects.nonNull(bodyMap.get("orgao_expedidor")))
            candidato.setOrgaoExpedidor(bodyMap.get("orgao_expedidor").toString());
        if(Objects.nonNull(bodyMap.get("estado_civil")))
            candidato.setEstadoCivil(Integer.parseInt(bodyMap.get("estado_civil").toString()));
        if(Objects.nonNull(bodyMap.get("fk_municipio_endereco")))
            candidato.setIdMunicipioEndereco(Integer.parseInt(bodyMap.get("fk_municipio_endereco").toString()));
        if(Objects.nonNull(bodyMap.get("grau_instrucao")))
            candidato.setGrauInstrucao(Integer.parseInt(bodyMap.get("grau_instrucao").toString()));
        if(Objects.nonNull(bodyMap.get("profissao")))
            candidato.setProfissao(Integer.parseInt(bodyMap.get("profissao").toString()));
        if(Objects.nonNull(bodyMap.get("email")))
            candidato.setEmail(bodyMap.get("email").toString());
        if(Objects.nonNull(bodyMap.get("fk_municipio_nascimento")))
            candidato.setIdMunicipioNascimento(Integer.parseInt(bodyMap.get("fk_municipio_nascimento").toString()));
        if(Objects.nonNull(bodyMap.get("uf_nascimento")))
            candidato.setUfNascimento(bodyMap.get("uf_nascimento").toString());
        if(Objects.nonNull(bodyMap.get("created_at")))
            candidato.setDataCriacao(utilsService.convertToDate(bodyMap.get("created_at").toString()));
        if(Objects.nonNull(bodyMap.get("updated_at")))
            candidato.setDataAtualizacao(utilsService.convertToDate(bodyMap.get("updated_at").toString()));
        if(Objects.nonNull(bodyMap.get("uf_orgao_expedidor")))
            candidato.setUfOrgaoExpedidor(bodyMap.get("uf_orgao_expedidor").toString());
        if(Objects.nonNull(bodyMap.get("data_emissao_doc")))
            candidato.setDataEmissaoDoc(utilsService.convertToDate(bodyMap.get("data_emissao_doc").toString()));
        if(Objects.nonNull(bodyMap.get("cpf_novo")))
            candidato.setCpfNovo(bodyMap.get("cpf_novo").toString());
        return candidato;
    }
}
