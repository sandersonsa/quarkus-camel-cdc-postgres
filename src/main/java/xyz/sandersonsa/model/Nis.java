package xyz.sandersonsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nis", schema = "popular")
public class Nis {
    
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nis")
    private String nis;
    @Column(name = "validado")
    private Boolean validado;
    @Column(name = "cpf")
    private String cpf;

    public Nis() {
    }

    public Nis(String nis, Boolean validado, String cpf) {
        this.nis = nis;
        this.validado = validado;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
}
