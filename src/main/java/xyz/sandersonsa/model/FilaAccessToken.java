package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fila_access_token", schema = "popular")
public class FilaAccessToken {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "expiration_access_token")
    private Date expirationAccessToken;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "source_ip")
    private String sourceIp;
    @Column(name = "user_agent")
    private String userAgent;

    public FilaAccessToken() {
    }

    public FilaAccessToken(String accessToken, Date expirationAccessToken, Date createdAt, Date updatedAt,
            Boolean ativo, String sourceIp, String userAgent) {
        this.accessToken = accessToken;
        this.expirationAccessToken = expirationAccessToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ativo = ativo;
        this.sourceIp = sourceIp;
        this.userAgent = userAgent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpirationAccessToken() {
        return expirationAccessToken;
    }

    public void setExpirationAccessToken(Date expirationAccessToken) {
        this.expirationAccessToken = expirationAccessToken;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}