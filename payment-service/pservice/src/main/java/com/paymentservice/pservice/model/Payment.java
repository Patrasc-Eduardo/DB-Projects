package com.paymentservice.pservice.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Payment {
    @Id
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;

    @NotNull
    private String clientName;
    private String description;
    @NotNull
    private Double amount;

    @OneToOne(cascade = CascadeType.ALL)
    CreditCard creditCard;

    @ManyToOne(cascade = CascadeType.ALL)
    Bank bank;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Payment(String name, String description, Double amount) {
        this.clientName = name;
        this.description = description;
        this.amount = amount;
    }
}
