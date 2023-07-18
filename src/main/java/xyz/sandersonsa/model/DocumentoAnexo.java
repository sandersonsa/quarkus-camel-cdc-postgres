package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento_anexo", schema = "popular")
public class DocumentoAnexo {
    
    @Id
    // @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fk_candidato_comissao")
    private Integer idCandidatoComissao;
    @Column(name = "hash_storage")
    private String hashStorage;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "fk_tipo_documento")
    private Integer idTipoDocumento;
    @Column(name = "deleted_at")
    private Date deletedAt;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "avaliador")
    private String avaliador;
    @Column(name = "nome_arquivo")
    private String nomeArquivo;
    @Column(name = "documento_base64")
    private String documentoBase64;

    public DocumentoAnexo() {
    }

    public DocumentoAnexo(Integer idCandidatoComissao, String hashStorage, Boolean ativo,
            Integer idTipoDocumento, Date deletedAt, Date createdAt, Date updatedAt, String avaliador,
            String nomeArquivo, String documentoBase64) {
        this.idCandidatoComissao = idCandidatoComissao;
        this.hashStorage = hashStorage;
        this.ativo = ativo;
        this.idTipoDocumento = idTipoDocumento;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.avaliador = avaliador;
        this.nomeArquivo = nomeArquivo;
        this.documentoBase64 = documentoBase64;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdCandidatoComissao() {
        return idCandidatoComissao;
    }

    public void setIdCandidatoComissao(Integer idCandidatoComissao) {
        this.idCandidatoComissao = idCandidatoComissao;
    }

    public String getHashStorage() {
        return hashStorage;
    }

    public void setHashStorage(String hashStorage) {
        this.hashStorage = hashStorage;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(String avaliador) {
        this.avaliador = avaliador;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getDocumentoBase64() {
        return documentoBase64;
    }

    public void setDocumentoBase64(String documentoBase64) {
        this.documentoBase64 = documentoBase64;
    }   
}