package xyz.sandersonsa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comissoes", schema = "popular")
public class Comissoes {
    
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_inicio_cadastro")
    private Date dataInicioCadastro;
    @Column(name = "data_fim_cadastro")
    private Date dataFimCadastro;
    @Column(name = "data_inicio_validacao")
    private Date dataInicioValidacao;
    @Column(name = "data_fim_validacao")
    private Date dataFimValidacao;
    @Column(name = "data_inicio_exame")
    private Date dataInicioExame;
    @Column(name = "status")
    private Integer status;
    @Column(name = "municipio_id")
    private Integer municipioId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "data_fim_exame")
    private Date dataFimExame;
    @Column(name = "operador_ultima_alteracao")
    private String operadorUltimaAlteracao;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "qtd_max_candidatos")
    private Integer qtdMaxCandidatos;
    @Column(name = "qtd_a")
    private Integer qtdA;
    @Column(name = "qtd_b")
    private Integer qtdB;
    @Column(name = "qtd_restante")
    private Integer qtdRestante;
    @Column(name = "local")
    private String local;
    @Column(name = "ano_ref")
    private String anoRef;
    @Column(name = "houve_distr_clinicas")
    private boolean houveDistrClinicas;


    public Comissoes() {
    }

    public Comissoes(Date dataInicioCadastro, Date dataFimCadastro, Date dataInicioValidacao,
            Date dataFimValidacao, Date dataInicioExame, Integer status, Integer municipioId, Date createdAt,
            Date dataFimExame, String operadorUltimaAlteracao, String categoria, Integer qtdMaxCandidatos, Integer qtdA,
            Integer qtdB, Integer qtdRestante, String local, String anoRef, boolean houveDistrClinicas) {
        
        this.dataInicioCadastro = dataInicioCadastro;
        this.dataFimCadastro = dataFimCadastro;
        this.dataInicioValidacao = dataInicioValidacao;
        this.dataFimValidacao = dataFimValidacao;
        this.dataInicioExame = dataInicioExame;
        this.status = status;
        this.municipioId = municipioId;
        this.createdAt = createdAt;
        this.dataFimExame = dataFimExame;
        this.operadorUltimaAlteracao = operadorUltimaAlteracao;
        this.categoria = categoria;
        this.qtdMaxCandidatos = qtdMaxCandidatos;
        this.qtdA = qtdA;
        this.qtdB = qtdB;
        this.qtdRestante = qtdRestante;
        this.local = local;
        this.anoRef = anoRef;
        this.houveDistrClinicas = houveDistrClinicas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInicioCadastro() {
        return dataInicioCadastro;
    }

    public void setDataInicioCadastro(Date dataInicioCadastro) {
        this.dataInicioCadastro = dataInicioCadastro;
    }

    public Date getDataFimCadastro() {
        return dataFimCadastro;
    }

    public void setDataFimCadastro(Date dataFimCadastro) {
        this.dataFimCadastro = dataFimCadastro;
    }

    public Date getDataInicioValidacao() {
        return dataInicioValidacao;
    }

    public void setDataInicioValidacao(Date dataInicioValidacao) {
        this.dataInicioValidacao = dataInicioValidacao;
    }

    public Date getDataFimValidacao() {
        return dataFimValidacao;
    }

    public void setDataFimValidacao(Date dataFimValidacao) {
        this.dataFimValidacao = dataFimValidacao;
    }

    public Date getDataInicioExame() {
        return dataInicioExame;
    }

    public void setDataInicioExame(Date dataInicioExame) {
        this.dataInicioExame = dataInicioExame;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Integer municipioId) {
        this.municipioId = municipioId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDataFimExame() {
        return dataFimExame;
    }

    public void setDataFimExame(Date dataFimExame) {
        this.dataFimExame = dataFimExame;
    }

    public String getOperadorUltimaAlteracao() {
        return operadorUltimaAlteracao;
    }

    public void setOperadorUltimaAlteracao(String operadorUltimaAlteracao) {
        this.operadorUltimaAlteracao = operadorUltimaAlteracao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQtdMaxCandidatos() {
        return qtdMaxCandidatos;
    }

    public void setQtdMaxCandidatos(Integer qtdMaxCandidatos) {
        this.qtdMaxCandidatos = qtdMaxCandidatos;
    }

    public Integer getQtdA() {
        return qtdA;
    }

    public void setQtdA(Integer qtdA) {
        this.qtdA = qtdA;
    }

    public Integer getQtdB() {
        return qtdB;
    }

    public void setQtdB(Integer qtdB) {
        this.qtdB = qtdB;
    }

    public Integer getQtdRestante() {
        return qtdRestante;
    }

    public void setQtdRestante(Integer qtdRestante) {
        this.qtdRestante = qtdRestante;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAnoRef() {
        return anoRef;
    }

    public void setAnoRef(String anoRef) {
        this.anoRef = anoRef;
    }

    public boolean isHouveDistrClinicas() {
        return houveDistrClinicas;
    }

    public void setHouveDistrClinicas(boolean houveDistrClinicas) {
        this.houveDistrClinicas = houveDistrClinicas;
    }

}