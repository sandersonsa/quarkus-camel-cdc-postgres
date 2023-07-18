package xyz.sandersonsa.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import xyz.sandersonsa.model.CandidatoComissao;

@ApplicationScoped
public class CandidatoComissaoRepository implements PanacheRepository<CandidatoComissao> {
    
}