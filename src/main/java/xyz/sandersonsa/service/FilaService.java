package xyz.sandersonsa.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FilaService {
    
    public void processarFila(String body) {
        System.out.println(" ## FilaService ## ");
        System.out.println(" ## body ## " + body);
    }
}
