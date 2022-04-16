package com.paymentservice.pservice.model;

import com.paymentservice.pservice.dto.PaymentDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Bank {
    @Id
    @Column(name = "bank_id", nullable = false)
    private Long bankId;

    private String description;
    private Double treasury;

    @OneToMany(cascade = CascadeType.ALL)
    List<Payment> processedPayments;

    public Bank() {
        treasury = 0.0;
        processedPayments = new ArrayList<Payment>();
    }

    public Payment acceptPayment(Payment payment) {
        this.getProcessedPayments().add(payment);
        this.setTreasury(treasury += payment.getAmount());
        return payment;
    }

    public Double getBankBalance() {
        return this.treasury;
    }
}
