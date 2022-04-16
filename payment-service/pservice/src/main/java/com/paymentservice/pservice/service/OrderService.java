package com.paymentservice.pservice.service;

import com.paymentservice.pservice.filters.PaymentFilter;
import com.paymentservice.pservice.model.Order;
import com.paymentservice.pservice.model.Payment;
import com.paymentservice.pservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
  @Autowired OrderRepository orderRepository;
  @Autowired PaymentServiceDev paymentServiceDev;
  @Autowired PaymentServiceProdSmallQuantity paymentServiceProdSmallQuantity;
  @Autowired PaymentServiceProdLargeQuantity paymentServiceProdLargeQuantity;
  PaymentFilter orderFilter = new PaymentFilter();

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public Optional<Order> getOrderById(Long id) {
    return orderRepository.findById(id);
  }

  public Order createOrder(Order order) {

    Payment payment =
        new Payment(
            order.getClient().getName(), order.getDescription(), order.getPayment().getAmount());

    orderRepository.save(order);

    if (order.getQuantity() <= 50.0) {
      paymentServiceProdSmallQuantity.orderAndPay(payment);
    } else {
      // filter for large quantities
      paymentServiceProdLargeQuantity.orderAndPay(payment);
    }

    return order;
  }

  public void deleteOrderById(Long id) {
    orderRepository.deleteById(id);
  }

  public Order updateOrder(Order order) {
    return orderRepository.save(order);
  }
}
