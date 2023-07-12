package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidato_item", schema = "popular")
public class TbCandidatoItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "fk_solicitacao_item")
    private Integer fkSolicitacaoItem;
    @Column(name = "dt_pessoa")
    private String dtPessoa;
    @Column(name = "renach")
    private String renach;
    @Column(name = "status")
    private Integer status;
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    @Column(name = "arquivo_anexo")
    private String arquivoAnexo;
    @Column(name = "usuario_entrega")
    private String usuarioEntrega;

    public TbCandidatoItem() {
    }

    public TbCandidatoItem(Integer fkSolicitacaoItem, String dtPessoa, String renach, Integer status, Date dataCadastro, String arquivoAnexo, String usuarioEntrega) {
        this.fkSolicitacaoItem = fkSolicitacaoItem;
        this.dtPessoa = dtPessoa;
        this.renach = renach;
        this.status = status;
        this.dataCadastro = dataCadastro;
        this.arquivoAnexo = arquivoAnexo;
        this.usuarioEntrega = usuarioEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkSolicitacaoItem() {
        return fkSolicitacaoItem;
    }

    public void setFkSolicitacaoItem(Integer fkSolicitacaoItem) {
        this.fkSolicitacaoItem = fkSolicitacaoItem;
    }

    public String getDtPessoa() {
        return dtPessoa;
    }

    public void setDtPessoa(String dtPessoa) {
        this.dtPessoa = dtPessoa;
    }

    public String getRenach() {
        return renach;
    }

    public void setRenach(String renach) {
        this.renach = renach;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getArquivoAnexo() {
        return arquivoAnexo;
    }

    public void setArquivoAnexo(String arquivoAnexo) {
        this.arquivoAnexo = arquivoAnexo;
    }

    public String getUsuarioEntrega() {
        return usuarioEntrega;
    }

    public void setUsuarioEntrega(String usuarioEntrega) {
        this.usuarioEntrega = usuarioEntrega;
    }   
}