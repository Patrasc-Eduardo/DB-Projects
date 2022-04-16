package com.paymentservice.pservice.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class PaymentDTO {
    @NotNull
    private String clientName;
    private String paymentDesc;
    @NotNull
    private Double amount;

    public PaymentDTO(String name, String description, Double amount) {
        this.clientName = name;
        this.paymentDesc = description;
        this.amount = amount;
    }
}
