package xyz.sandersonsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_capacete_popular", schema = "popular")
public class TbCapacetePopular {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;
    @Column(name = "disponivel")
    private Boolean disponivel;
    @Column(name = "fk_cod_material")
    private Integer fkCodMaterial;

    public TbCapacetePopular() {
    }

    public TbCapacetePopular(String descricao, Boolean disponivel, Integer fkCodMaterial) {
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.fkCodMaterial = fkCodMaterial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getFkCodMaterial() {
        return fkCodMaterial;
    }

    public void setFkCodMaterial(Integer fkCodMaterial) {
        this.fkCodMaterial = fkCodMaterial;
    }   
    
}