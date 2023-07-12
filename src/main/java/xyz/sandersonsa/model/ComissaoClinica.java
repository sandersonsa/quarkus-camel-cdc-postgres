package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comissao_clinica", schema = "popular")
public class ComissaoClinica {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comissao_id")
    private Integer idComissao;
    @Column(name = "clinica_id")
    private Integer idClinica;
    @Column(name = "excedente")
    private boolean excedente;
    @Column(name = "created_at")
    private Date dataCriacao;
    @Column(name = "medico")
    private boolean medico;
    @Column(name = "psicologico")
    private boolean psicologico;
    @Column(name = "cota")
    private Integer cota;

    public ComissaoClinica() {
    }

    public ComissaoClinica(Integer idComissao, Integer idClinica, boolean excedente, Date dataCriacao,
            boolean medico, boolean psicologico, Integer cota) {
        
        this.idComissao = idComissao;
        this.idClinica = idClinica;
        this.excedente = excedente;
        this.dataCriacao = dataCriacao;
        this.medico = medico;
        this.psicologico = psicologico;
        this.cota = cota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdComissao() {
        return idComissao;
    }

    public void setIdComissao(Integer idComissao) {
        this.idComissao = idComissao;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public boolean isExcedente() {
        return excedente;
    }

    public void setExcedente(boolean excedente) {
        this.excedente = excedente;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isMedico() {
        return medico;
    }

    public void setMedico(boolean medico) {
        this.medico = medico;
    }

    public boolean isPsicologico() {
        return psicologico;
    }

    public void setPsicologico(boolean psicologico) {
        this.psicologico = psicologico;
    }

    public Integer getCota() {
        return cota;
    }

    public void setCota(Integer cota) {
        this.cota = cota;
    }

    

}