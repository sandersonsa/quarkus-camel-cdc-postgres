package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidatos", schema = "popular")
public class Candidato {

    @Id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_mae")
    private String nomeMae;
    @Column(name = "nome_pai")
    private String nomePai;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "cep")
    private String cep;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "uf_endereco")
    private String ufEndereco;
    @Column(name = "ddd_residencial")
    private String dddResidencial;
    @Column(name = "telefone_residencial")
    private String telefoneResidencial;
    @Column(name = "ddd_celular")
    private String dddCelular;
    @Column(name = "telefone_celular")
    private String telefoneCelular;
    @Column(name = "num_documento")
    private String numDocumento;
    @Column(name = "orgao_expedidor")
    private String orgaoExpedidor;
    @Column(name = "nis")
    private String nis;
    @Column(name = "estado_civil")
    private Integer estadoCivil;
    @Column(name = "fk_municipio_endereco")
    private Integer idMunicipioEndereco;
    @Column(name = "grau_instrucao")
    private Integer grauInstrucao;
    @Column(name = "profissao")
    private Integer profissao;
    @Column(name = "email")
    private String email;
    @Column(name = "fk_municipio_nascimento")
    private Integer idMunicipioNascimento;
    @Column(name = "uf_nascimento")
    private String ufNascimento;
    @Column(name = "created_at")
    private Date dataCriacao;
    @Column(name = "updated_at")
    private Date dataAtualizacao;
    @Column(name = "uf_orgao_expedidor")
    private String ufOrgaoExpedidor;
    @Column(name = "tipo_documento")
    private Integer tipoDocumento;
    @Column(name = "data_emissao_doc")
    private Date dataEmissaoDoc;
    @Column(name = "cpf_novo")
    private String cpfNovo;    


    public Candidato() {
    }

    public Candidato(String cpf, Date dataNascimento, String nome, String nomeMae, String nomePai,
            String sexo, String cep, String logradouro, String numero, String bairro, String complemento,
            String ufEndereco, String dddResidencial, String telefoneResidencial, String dddCelular,
            String telefoneCelular, String numDocumento, String orgaoExpedidor, String nis, Integer estadoCivil,
            Integer idMunicipioEndereco, Integer grauInstrucao, Integer profissao, String email,
            Integer idMunicipioNascimento, String ufNascimento, Date dataCriacao, Date dataAtualizacao,
            String ufOrgaoExpedidor, Integer tipoDocumento, Date dataEmissaoDoc, String cpfNovo) {
        
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.sexo = sexo;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.ufEndereco = ufEndereco;
        this.dddResidencial = dddResidencial;
        this.telefoneResidencial = telefoneResidencial;
        this.dddCelular = dddCelular;
        this.telefoneCelular = telefoneCelular;
        this.numDocumento = numDocumento;
        this.orgaoExpedidor = orgaoExpedidor;
        this.nis = nis;
        this.estadoCivil = estadoCivil;
        this.idMunicipioEndereco = idMunicipioEndereco;
        this.grauInstrucao = grauInstrucao;
        this.profissao = profissao;
        this.email = email;
        this.idMunicipioNascimento = idMunicipioNascimento;
        this.ufNascimento = ufNascimento;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.ufOrgaoExpedidor = ufOrgaoExpedidor;
        this.tipoDocumento = tipoDocumento;
        this.dataEmissaoDoc = dataEmissaoDoc;
        this.cpfNovo = cpfNovo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNomeMae() {
        return nomeMae;
    }
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    public String getNomePai() {
        return nomePai;
    }
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getUfEndereco() {
        return ufEndereco;
    }
    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }
    public String getDddResidencial() {
        return dddResidencial;
    }
    public void setDddResidencial(String dddResidencial) {
        this.dddResidencial = dddResidencial;
    }
    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }
    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }
    public String getDddCelular() {
        return dddCelular;
    }
    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }
    public String getTelefoneCelular() {
        return telefoneCelular;
    }
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
    public String getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }
    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }
    public String getNis() {
        return nis;
    }
    public void setNis(String nis) {
        this.nis = nis;
    }
    public Integer getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Integer getIdMunicipioEndereco() {
        return idMunicipioEndereco;
    }
    public void setIdMunicipioEndereco(Integer idMunicipioEndereco) {
        this.idMunicipioEndereco = idMunicipioEndereco;
    }
    public Integer getGrauInstrucao() {
        return grauInstrucao;
    }
    public void setGrauInstrucao(Integer grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }
    public Integer getProfissao() {
        return profissao;
    }
    public void setProfissao(Integer profissao) {
        this.profissao = profissao;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getIdMunicipioNascimento() {
        return idMunicipioNascimento;
    }
    public void setIdMunicipioNascimento(Integer idMunicipioNascimento) {
        this.idMunicipioNascimento = idMunicipioNascimento;
    }
    public String getUfNascimento() {
        return ufNascimento;
    }
    public void setUfNascimento(String ufNascimento) {
        this.ufNascimento = ufNascimento;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    public String getUfOrgaoExpedidor() {
        return ufOrgaoExpedidor;
    }
    public void setUfOrgaoExpedidor(String ufOrgaoExpedidor) {
        this.ufOrgaoExpedidor = ufOrgaoExpedidor;
    }
    public Integer getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public Date getDataEmissaoDoc() {
        return dataEmissaoDoc;
    }
    public void setDataEmissaoDoc(Date dataEmissaoDoc) {
        this.dataEmissaoDoc = dataEmissaoDoc;
    }
    public String getCpfNovo() {
        return cpfNovo;
    }
    public void setCpfNovo(String cpfNovo) {
        this.cpfNovo = cpfNovo;
    }

    
    
}

/**
 * id
 * cpf
 * data_nascimento
 * nome
 * nome_mae
 * nome_pai
 * sexo
 * cep
 * logradouro
 * numero
 * bairro
 * complemento
 * uf_endereco
 * ddd_residencial
 * telefone_residencial
 * ddd_celular
 * telefone_celular
 * num_documento
 * orgao_expedidor
 * nis
 * estado_civil
 * fk_municipio_endereco
 * grau_instrucao
 * profissao
 * email
 * fk_municipio_nascimento
 * uf_nascimento
 * created_at
 * updated_at
 * uf_orgao_expedidor
 * tipo_documento
 * data_emissao_doc
 * cpf_novo
 */
