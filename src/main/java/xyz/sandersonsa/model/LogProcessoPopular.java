package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log_processo_popular", schema = "popular")
public class LogProcessoPopular {

    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fk_processo")
    private Integer fkProcesso;
    @Column(name = "acao")
    private String acao;
    @Column(name = "created_at")
    private Date createdAt;

    public LogProcessoPopular() {
    }

    public LogProcessoPopular(Integer fkProcesso, String acao, Date createdAt) {
        this.fkProcesso = fkProcesso;
        this.acao = acao;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkProcesso() {
        return fkProcesso;
    }

    public void setFkProcesso(Integer fkProcesso) {
        this.fkProcesso = fkProcesso;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }    
}
