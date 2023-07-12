package xyz.sandersonsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidato_restricoes", schema = "popular")
public class CandidatoRestricao {

    @Id
    private Integer id;
    
    @Column(name = "candidato_comissao_id")
    private Integer idCandidatoComissao;
    @Column(name = "restricao")
    private String restricao;
    
    
    
    public CandidatoRestricao(Integer id, Integer idCandidatoComissao, String restricao) {
        this.id = id;
        this.idCandidatoComissao = idCandidatoComissao;
        this.restricao = restricao;
    }

    public CandidatoRestricao() {
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdCandidatoComissao() {
        return idCandidatoComissao;
    }
    public void setIdCandidatoComissao(Integer idCandidatoComissao) {
        this.idCandidatoComissao = idCandidatoComissao;
    }
    public String getRestricao() {
        return restricao;
    }
    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }
    
    
    
}
