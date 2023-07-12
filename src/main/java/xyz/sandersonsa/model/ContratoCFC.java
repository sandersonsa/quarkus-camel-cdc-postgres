package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contrato_cfc", schema = "popular")
public class ContratoCFC {
    
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dt_pessoa")
    private String dtPessoa;
    @Column(name = "contrato")
    private String contrato;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "fk_comissao")
    private Integer fkComissao;
    @Column(name = "operador")
    private String operador;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "data_inativacao")
    private Date dataInativacao;

    public ContratoCFC() {
    }

    public ContratoCFC(String dtPessoa, String contrato, Date createdAt, Date updatedAt,
            Integer fkComissao, String operador, Boolean ativo, Date dataInativacao) {        
        this.dtPessoa = dtPessoa;
        this.contrato = contrato;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.fkComissao = fkComissao;
        this.operador = operador;
        this.ativo = ativo;
        this.dataInativacao = dataInativacao;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDtPessoa() {
        return dtPessoa;
    }
    public void setDtPessoa(String dtPessoa) {
        this.dtPessoa = dtPessoa;
    }
    public String getContrato() {
        return contrato;
    }
    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Integer getFkComissao() {
        return fkComissao;
    }
    public void setFkComissao(Integer fkComissao) {
        this.fkComissao = fkComissao;
    }
    public String getOperador() {
        return operador;
    }
    public void setOperador(String operador) {
        this.operador = operador;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public Date getDataInativacao() {
        return dataInativacao;
    }
    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }   
}