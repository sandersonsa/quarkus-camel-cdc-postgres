package xyz.sandersonsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_documento", schema = "popular")
public class TipoDocumento {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "cod_documento")
    private Integer codDocumento;

    public TipoDocumento() {
    }

    public TipoDocumento(String descricao, Integer codDocumento) {
        this.descricao = descricao;
        this.codDocumento = codDocumento;
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

    public Integer getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(Integer codDocumento) {
        this.codDocumento = codDocumento;
    }

    
    
}
