package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_solicitacao_item", schema = "popular")
public class TbSolicitacaoItem {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fk_solicitacao")
    private Integer fkSolicitacao;
    @Column(name = "fk_capacete")
    private Integer fkCapacete;
    @Column(name = "qtd_solicitada")
    private Integer qtdSolicitada;
    @Column(name = "qtd_confirmada")
    private Integer qtdConfirmada;
    @Column(name = "usuario_cadastro")
    private String usuarioCadastro;
    @Column(name = "usuario_alteracao")
    private String usuarioAlteracao;
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    public TbSolicitacaoItem() {
    }

    public TbSolicitacaoItem(Integer fkSolicitacao, Integer fkCapacete, Integer qtdSolicitada, Integer qtdConfirmada, String usuarioCadastro, String usuarioAlteracao, Date dataCadastro, Date dataAlteracao) {
        this.fkSolicitacao = fkSolicitacao;
        this.fkCapacete = fkCapacete;
        this.qtdSolicitada = qtdSolicitada;
        this.qtdConfirmada = qtdConfirmada;
        this.usuarioCadastro = usuarioCadastro;
        this.usuarioAlteracao = usuarioAlteracao;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkSolicitacao() {
        return fkSolicitacao;
    }

    public void setFkSolicitacao(Integer fkSolicitacao) {
        this.fkSolicitacao = fkSolicitacao;
    }

    public Integer getFkCapacete() {
        return fkCapacete;
    }

    public void setFkCapacete(Integer fkCapacete) {
        this.fkCapacete = fkCapacete;
    }

    public Integer getQtdSolicitada() {
        return qtdSolicitada;
    }

    public void setQtdSolicitada(Integer qtdSolicitada) {
        this.qtdSolicitada = qtdSolicitada;
    }

    public Integer getQtdConfirmada() {
        return qtdConfirmada;
    }

    public void setQtdConfirmada(Integer qtdConfirmada) {
        this.qtdConfirmada = qtdConfirmada;
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

    
    
    
}

/**
 * id
 * 	fk_solicitacao
 * 	fk_capacete
 * 	qtd_solicitada
 * 	qtd_confirmada
 * 	usuario_cadastro
 * 	usuario_alteracao
 * 	data_cadastro
 * 	data_alteracao
 */