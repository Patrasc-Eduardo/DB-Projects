package com.paymentservice.pservice.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CreditCard {
    @Id
    @GeneratedValue
    @NotNull
    private Long cardId;
    @NotNull
    private String ownerName;
    @NotNull
    private String cardDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    Client client;

    @OneToMany(cascade = CascadeType.ALL)
    List<Payment> allPayments;
}
