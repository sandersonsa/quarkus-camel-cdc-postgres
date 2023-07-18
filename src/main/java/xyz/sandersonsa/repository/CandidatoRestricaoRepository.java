package xyz.sandersonsa.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import xyz.sandersonsa.model.CandidatoComissao;
import xyz.sandersonsa.model.CandidatoRestricao;

@ApplicationScoped
public class CandidatoRestricaoRepository implements PanacheRepository<CandidatoRestricao> {
    
}
