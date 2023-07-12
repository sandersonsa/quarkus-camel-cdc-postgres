package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anexos_pendentes", schema = "popular")
public class AnexosPendentes {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fk_julgamento_processo")
    private Integer idJulgamentoProcesso;
    @Column(name = "fk_tipo_documento")
    private Integer idTipoDocumento;
    @Column(name = "created_at")
    private Date dataCriacao;
    
    public AnexosPendentes() {
    }

    public AnexosPendentes(Integer idJulgamentoProcesso, Integer idTipoDocumento, Date dataCriacao) {
        
        this.idJulgamentoProcesso = idJulgamentoProcesso;
        this.idTipoDocumento = idTipoDocumento;
        this.dataCriacao = dataCriacao;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdJulgamentoProcesso() {
        return idJulgamentoProcesso;
    }
    public void setIdJulgamentoProcesso(Integer idJulgamentoProcesso) {
        this.idJulgamentoProcesso = idJulgamentoProcesso;
    }
    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }
    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    
    
}
