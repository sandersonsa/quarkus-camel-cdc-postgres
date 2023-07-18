package xyz.sandersonsa.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import xyz.sandersonsa.model.FilaAccessToken;
import xyz.sandersonsa.model.JulgamentoProcesso;

@ApplicationScoped
public class FilaAcessRepository implements PanacheRepository<FilaAccessToken> {
    
}