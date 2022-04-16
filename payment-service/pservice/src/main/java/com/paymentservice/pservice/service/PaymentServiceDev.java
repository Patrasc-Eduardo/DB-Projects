package com.paymentservice.pservice.service;

import com.paymentservice.pservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class PaymentServiceDev {
  @Autowired BankService bankService;

  public void orderAndPay(Payment payment) {
    bankService.accceptPayments(payment);
  }
}
