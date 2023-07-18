package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "julgamento_processo", schema = "popular")
public class JulgamentoProcesso {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fk_candidato_comissao")
    private Integer idCandidatoComissao;
    @Column(name = "fk_status_validacao")
    private Integer idStatusValidacao;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "operador")
    private String operador;
    
    public JulgamentoProcesso() {
    }

    public JulgamentoProcesso(Integer idCandidatoComissao, Integer idStatusValidacao, String observacao,
            Date createdAt, Date updatedAt, Boolean ativo, String operador) {
        this.idCandidatoComissao = idCandidatoComissao;
        this.idStatusValidacao = idStatusValidacao;
        this.observacao = observacao;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ativo = ativo;
        this.operador = operador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdCandidatoComissao() {
        return idCandidatoComissao;
    }

    public void setIdCandidatoComissao(Integer idCandidatoComissao) {
        this.idCandidatoComissao = idCandidatoComissao;
    }

    public Integer getIdStatusValidacao() {
        return idStatusValidacao;
    }

    public void setIdStatusValidacao(Integer idStatusValidacao) {
        this.idStatusValidacao = idStatusValidacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }   
}