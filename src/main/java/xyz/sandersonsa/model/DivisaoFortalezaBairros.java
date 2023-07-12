package xyz.sandersonsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "divisao_fortaleza_bairros", schema = "popular")
public class DivisaoFortalezaBairros {
    
    @Id 
    private Integer id;

    @Column(name = "regional")
    private Integer regional;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "posto")
    private String posto;
    @Column(name = "cod_posto")
    private Integer codPosto;

    public DivisaoFortalezaBairros() {
    }

    public DivisaoFortalezaBairros(Integer id, Integer regional, String bairro, String posto, Integer codPosto) {
        this.id = id;
        this.regional = regional;
        this.bairro = bairro;
        this.posto = posto;
        this.codPosto = codPosto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegional() {
        return regional;
    }

    public void setRegional(Integer regional) {
        this.regional = regional;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public Integer getCodPosto() {
        return codPosto;
    }

    public void setCodPosto(Integer codPosto) {
        this.codPosto = codPosto;
    }

    
}