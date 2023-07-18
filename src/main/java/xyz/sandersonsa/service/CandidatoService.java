package xyz.sandersonsa.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.sandersonsa.model.Candidato;
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
        logger.info(" ## PROCESSAR CANDIDATO ## - {}", operation);

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
        candidato.setNumero(bodyMap.get("numero").toString());
        candidato.setBairro(bodyMap.get("bairro").toString());
        if(Objects.nonNull(bodyMap.get("complemento")))
            candidato.setComplemento(bodyMap.get("complemento").toString());
        candidato.setUfEndereco(bodyMap.get("uf_endereco").toString());
        candidato.setDddResidencial(bodyMap.get("ddd_residencial").toString());
        candidato.setTelefoneResidencial(bodyMap.get("telefone_residencial").toString());
        candidato.setDddCelular(bodyMap.get("ddd_celular").toString());
        candidato.setTelefoneCelular(bodyMap.get("telefone_celular").toString());
        candidato.setNumDocumento(bodyMap.get("num_documento").toString());
        candidato.setOrgaoExpedidor(bodyMap.get("orgao_expedidor").toString());
        candidato.setEstadoCivil(Integer.parseInt(bodyMap.get("estado_civil").toString()));
        candidato.setIdMunicipioEndereco(Integer.parseInt(bodyMap.get("fk_municipio_endereco").toString()));
        candidato.setGrauInstrucao(Integer.parseInt(bodyMap.get("grau_instrucao").toString()));
        candidato.setProfissao(Integer.parseInt(bodyMap.get("profissao").toString()));
        candidato.setEmail(bodyMap.get("email").toString());
        candidato.setIdMunicipioNascimento(Integer.parseInt(bodyMap.get("fk_municipio_nascimento").toString()));
        candidato.setUfNascimento(bodyMap.get("uf_nascimento").toString());
        candidato.setDataCriacao(utilsService.convertToDate(bodyMap.get("created_at").toString()));
        candidato.setDataAtualizacao(utilsService.convertToDate(bodyMap.get("updated_at").toString()));
        candidato.setUfOrgaoExpedidor(bodyMap.get("uf_orgao_expedidor").toString());
        candidato.setDataEmissaoDoc(utilsService.convertToDate(bodyMap.get("data_emissao_doc").toString()));
        candidato.setCpfNovo(bodyMap.get("cpf_novo").toString());
        return candidato;
    }
}
