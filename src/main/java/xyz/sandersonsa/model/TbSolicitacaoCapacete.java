package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_solicitacao_capacete", schema = "popular")
public class TbSolicitacaoCapacete {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "fk_requisicao")
    private Integer fkRequisicao;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "fl_status")
    private Integer flStatus;
    @Column(name = "usuario_cadastro")
    private String usuarioCadastro;
    @Column(name = "usuario_alteracao")
    private String usuarioAlteracao;
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    @Column(name = "data_alteracao")
    private Date dataAlteracao;
    @Column(name = "posto_entrega")
    private String postoEntrega;

    public TbSolicitacaoCapacete() {
    }

    public TbSolicitacaoCapacete(Integer fkRequisicao, String municipio, Integer flStatus, String usuarioCadastro, String usuarioAlteracao, Date dataCadastro, Date dataAlteracao, String postoEntrega) {
        this.fkRequisicao = fkRequisicao;
        this.municipio = municipio;
        this.flStatus = flStatus;
        this.usuarioCadastro = usuarioCadastro;
        this.usuarioAlteracao = usuarioAlteracao;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.postoEntrega = postoEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkRequisicao() {
        return fkRequisicao;
    }

    public void setFkRequisicao(Integer fkRequisicao) {
        this.fkRequisicao = fkRequisicao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getFlStatus() {
        return flStatus;
    }

    public void setFlStatus(Integer flStatus) {
        this.flStatus = flStatus;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getPostoEntrega() {
        return postoEntrega;
    }

    public void setPostoEntrega(String postoEntrega) {
        this.postoEntrega = postoEntrega;
    }

    
    
    
}