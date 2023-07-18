package xyz.sandersonsa.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import xyz.sandersonsa.model.Fila;

@ApplicationScoped
public class FilaRepository implements PanacheRepository<Fila> {
    
}