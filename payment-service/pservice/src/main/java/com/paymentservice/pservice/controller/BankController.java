package com.paymentservice.pservice.controller;

import com.paymentservice.pservice.dto.PaymentDTO;
import com.paymentservice.pservice.model.Payment;
import com.paymentservice.pservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @PostMapping("/bank/accept")
    public Double accceptPayments(@RequestBody Payment payment) {
        return bankService.accceptPayments(payment);
    }

    @GetMapping("/bank/balance")
    public Double getBankBalance() {
        return bankService.getBankBalance();
    }
}
