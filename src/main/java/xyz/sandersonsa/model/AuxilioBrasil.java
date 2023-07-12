package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auxbrasil", schema = "popular")
public class AuxilioBrasil {
    
    @Id
    private Integer id;
    
    @Column(name = "municpio")
    private String municipio;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nomemae")
    private String nomeMae;
    @Column(name = "created_at")
    private Date dataCriacao;
    @Column(name = "data_nascimento")
    private Date dataNascimento;


    public AuxilioBrasil() {
    }

    public AuxilioBrasil(Integer id, String municipio, String nome, String cpf, String nomeMae, Date dataCriacao,
            Date dataNascimento) {
        this.id = id;
        this.municipio = municipio;
        this.nome = nome;
        this.cpf = cpf;
        this.nomeMae = nomeMae;
        this.dataCriacao = dataCriacao;
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNomeMae() {
        return nomeMae;
    }
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    

}
