package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comissao_cfc", schema = "popular")
public class ComissaoCFC {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comissao_id")
    private Integer comissaoId;
    @Column(name = "dt_pessoa_cfc")
    private String dtPessoaCfc;
    @Column(name = "created_at")
    private Date createdAt;

    public ComissaoCFC() {
    }

    public ComissaoCFC(Integer comissaoId, String dtPessoaCfc, Date createdAt) {
        
        this.comissaoId = comissaoId;
        this.dtPessoaCfc = dtPessoaCfc;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComissaoId() {
        return comissaoId;
    }

    public void setComissaoId(Integer comissaoId) {
        this.comissaoId = comissaoId;
    }

    public String getDtPessoaCfc() {
        return dtPessoaCfc;
    }

    public void setDtPessoaCfc(String dtPessoaCfc) {
        this.dtPessoaCfc = dtPessoaCfc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    

}

/**
 * id
 * comissao_id
 * dt_pessoa_cfc
 * created_at
 */