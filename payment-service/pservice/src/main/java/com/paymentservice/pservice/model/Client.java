package com.paymentservice.pservice.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue
    @NotNull
    private Long clientId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    List<CreditCard> creditCards;

    @OneToMany(cascade = CascadeType.ALL)
    List<Order> orders;
}
