package com.paymentservice.pservice.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders_table")
@Data
public class Order {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;
    @NotNull
    private String description;
    private String orderDate;
    private String shippedDate;
    private Double quantity;
    //private Payment payment;

    @JoinColumn( name = "client_id")
    @ManyToOne(cascade = CascadeType.ALL)
    Client client;

    @JoinColumn( name = "payment_id")
    @ManyToOne(cascade = CascadeType.ALL)
    Payment payment;

}
