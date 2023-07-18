package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidato_comissao", schema = "popular")
public class CandidatoComissao {

    @Id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fk_candidato")
    private Integer idCandidato;
    @Column(name = "fk_comissao")
    private Integer idComissao;
    @Column(name = "created_at")
    private Date dataCriacao;
    @Column(name = "ativo")
    private boolean ativo;
    @Column(name = "updated_at")
    private Date dataAtualizacao;
    @Column(name = "fk_motivo_validacao")
    private Integer idMotivoValidacao;
    @Column(name = "fk_capacete")
    private Integer idCapacete;
    @Column(name = "categoria")
    private String categoria;

    public CandidatoComissao() {
    }

    public CandidatoComissao(Integer idCandidato, Integer idComissao, Date dataCriacao, boolean ativo,
            Date dataAtualizacao, Integer idMotivoValidacao, Integer idCapacete, String categoria) {
        
        this.idCandidato = idCandidato;
        this.idComissao = idComissao;
        this.dataCriacao = dataCriacao;
        this.ativo = ativo;
        this.dataAtualizacao = dataAtualizacao;
        this.idMotivoValidacao = idMotivoValidacao;
        this.idCapacete = idCapacete;
        this.categoria = categoria;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getIdCandidato() {
        return idCandidato;
    }
    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }
    public Integer getIdComissao() {
        return idComissao;
    }
    public void setIdComissao(Integer idComissao) {
        this.idComissao = idComissao;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    public Integer getIdMotivoValidacao() {
        return idMotivoValidacao;
    }
    public void setIdMotivoValidacao(Integer idMotivoValidacao) {
        this.idMotivoValidacao = idMotivoValidacao;
    }
    public Integer getIdCapacete() {
        return idCapacete;
    }
    public void setIdCapacete(Integer idCapacete) {
        this.idCapacete = idCapacete;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    
}
