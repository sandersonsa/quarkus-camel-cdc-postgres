package xyz.sandersonsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "divisao_fortaleza_bairros_cfc", schema = "popular")
public class DivisaoFortalezaBairrosCFC {
    
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "regional")
    private Integer regional;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "posto")
    private String posto;
    @Column(name = "cod_posto")
    private String codPosto;

    public DivisaoFortalezaBairrosCFC() {
    }

    public DivisaoFortalezaBairrosCFC(Integer regional, String cnpj, String posto, String codPosto) {
        this.regional = regional;
        this.cnpj = cnpj;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getCodPosto() {
        return codPosto;
    }

    public void setCodPosto(String codPosto) {
        this.codPosto = codPosto;
    }   
}