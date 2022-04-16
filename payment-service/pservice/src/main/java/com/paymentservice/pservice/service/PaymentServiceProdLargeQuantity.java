package com.paymentservice.pservice.service;

import com.paymentservice.pservice.filters.PaymentFilter;
import com.paymentservice.pservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class PaymentServiceProdLargeQuantity {

  @Autowired BankService bankService;

  public void orderAndPay(Payment payment) {
    System.out.println("Payment service for large quantity");
    PaymentFilter paymentFilter = new PaymentFilter();
    paymentFilter.filterPayment(payment);
    bankService.accceptPayments(payment);
  }
}
