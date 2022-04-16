package com.paymentservice.pservice.filters;

import com.paymentservice.pservice.model.Order;
import com.paymentservice.pservice.model.Payment;

public class PaymentFilter {

    public String filterPayment(Payment payment) {
        return "Payment was filtered";
    }
}
