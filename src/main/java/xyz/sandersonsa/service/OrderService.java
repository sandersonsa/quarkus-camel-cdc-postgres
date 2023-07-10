package xyz.sandersonsa.service;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

import xyz.sandersonsa.model.Orders;

@ApplicationScoped
public class OrderService {

    // Transaction method
    @Transactional
    public Orders inserOrder(Orders orders) {
        // Persists data
        orders.persist();        
        return orders;
    }
}

    // @PersistenceContext
    // EntityManager em;

    // @Transactional
    // public void salvar(Object obj) {
    //     em.persist(obj);
    // }


// @ApplicationScoped
// public class SantaClausService {
//     @Inject
//     EntityManager em; 

//     @Transactional 
//     public void createGift(String giftDescription) {
//         Gift gift = new Gift();
//         gift.setName(giftDescription);
//         em.persist(gift);
//     }
// }


// @Entity
// public class Gift {
//     private Long id;
//     private String name;

//     @Id
//     @SequenceGenerator(name = "giftSeq", sequenceName = "gift_id_seq", allocationSize = 1, initialValue = 1)
//     @GeneratedValue(generator = "giftSeq")
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }
// }

// # datasource configuration
// quarkus.datasource.db-kind = postgresql
// quarkus.datasource.username = hibernate
// quarkus.datasource.password = hibernate
// quarkus.datasource.jdbc.url = jdbc:postgresql://localhost:5432/hibernate_db

// # drop and create the database at startup (use `update` to only update the schema)
// quarkus.hibernate-orm.database.generation=drop-and-create
