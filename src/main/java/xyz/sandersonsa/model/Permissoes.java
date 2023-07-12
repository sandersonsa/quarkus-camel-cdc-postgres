package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permissoes", schema = "popular")
public class Permissoes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dt_pessoa_operador")
    private String dtPessoaOperador;
    @Column(name = "operacao_id")
    private Integer idOperacao;
    @Column(name = "created_at")
    private Date dataCriacao;

    public Permissoes() {
    }


    public Permissoes(String dtPessoaOperador, Integer idOperacao, Date dataCriacao) {
        this.dtPessoaOperador = dtPessoaOperador;
        this.idOperacao = idOperacao;
        this.dataCriacao = dataCriacao;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getDtPessoaOperador() {
        return dtPessoaOperador;
    }


    public void setDtPessoaOperador(String dtPessoaOperador) {
        this.dtPessoaOperador = dtPessoaOperador;
    }


    public Integer getIdOperacao() {
        return idOperacao;
    }


    public void setIdOperacao(Integer idOperacao) {
        this.idOperacao = idOperacao;
    }


    public Date getDataCriacao() {
        return dataCriacao;
    }


    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }   
}
