package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alteracao_comissao", schema = "popular")
public class AlteracaoComissao {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comissao_id")
    private String comissaoId;
    @Column(name = "operador")
    private String operador;
    @Column(name = "created_at")
    private Date createdAt;

    public AlteracaoComissao() {
    }

    public AlteracaoComissao(String comissaoId, String operador, Date createdAt) {
        
        this.comissaoId = comissaoId;
        this.operador = operador;
        this.createdAt = createdAt;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getComissaoId() {
        return comissaoId;
    }
    public void setComissaoId(String comissaoId) {
        this.comissaoId = comissaoId;
    }
    public String getOperador() {
        return operador;
    }
    public void setOperador(String operador) {
        this.operador = operador;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
