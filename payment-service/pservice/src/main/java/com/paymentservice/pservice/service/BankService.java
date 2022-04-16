package com.paymentservice.pservice.service;

import com.paymentservice.pservice.model.Bank;
import com.paymentservice.pservice.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    Bank bank = new Bank();

    public Double accceptPayments(Payment payment) {
        bank.acceptPayment(payment);
        return payment.getAmount();
    }

    public Double getBankBalance() {
        return bank.getBankBalance();
    }
}
