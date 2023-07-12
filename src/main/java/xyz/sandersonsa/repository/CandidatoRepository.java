package xyz.sandersonsa.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import xyz.sandersonsa.model.Candidato;

@ApplicationScoped
public class CandidatoRepository implements PanacheRepository<Candidato> {
    
}
