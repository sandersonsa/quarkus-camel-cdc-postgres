package xyz.sandersonsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ceps_popular_ceara", schema = "popular")
public class CepsPopularCeara {
    
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "cep")
    private String cep;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "uf")
    private String uf;
    @Column(name = "codmunic")
    private String codmunic;
    @Column(name = "municipio")
    private String municipio;

    public CepsPopularCeara() {
    }

    public CepsPopularCeara(String cep, String logradouro, String bairro, String uf, String codmunic,
            String municipio) {
        
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.uf = uf;
        this.codmunic = codmunic;
        this.municipio = municipio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodmunic() {
        return codmunic;
    }

    public void setCodmunic(String codmunic) {
        this.codmunic = codmunic;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    
    
}

/**
 * cep
 * logradouro
 * bairro
 * uf
 * codmunic
 * municipio
 * id
 */