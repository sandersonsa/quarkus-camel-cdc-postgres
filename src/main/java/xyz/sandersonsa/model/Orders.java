package xyz.sandersonsa.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.xml.crypto.Data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Orders extends PanacheEntity {

    public Orders() {
    }

    public Orders(String orderid, Date orderdate, String sku, String description, double amount) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.sku = sku;
        this.description = description;
        this.amount = amount;
    }

    public String orderid;
    public Date orderdate;
    private String sku;
    private String description;
    private double amount;
}


/*
 * create table braindose.orders(
 * orderid text PRIMARY KEY,
 * orderdate timestamp NOT NULL,
 * sku text NOT NULL,
 * description text NOT NULL,
 * amount double precision NOT NULL
 * );
 */