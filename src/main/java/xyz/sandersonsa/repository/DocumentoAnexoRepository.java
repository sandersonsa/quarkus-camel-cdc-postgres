package xyz.sandersonsa.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import xyz.sandersonsa.model.DocumentoAnexo;

@ApplicationScoped
public class DocumentoAnexoRepository implements PanacheRepository<DocumentoAnexo> {
    
}
