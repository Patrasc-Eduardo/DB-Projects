package com.paymentservice.pservice.controller;

import com.paymentservice.pservice.model.Order;
import com.paymentservice.pservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
  @Autowired OrderService orderService;

  @GetMapping("/orders")
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/orders/{id}")
  public Optional<Order> getOrderById(@PathVariable Long id) {
    return orderService.getOrderById(id);
  }

  @PostMapping("/orders/create")
  public Order createOrder(@RequestBody Order order) {
    return orderService.createOrder(order);
  }

  @DeleteMapping("/orders/{id}")
  public void deleteOrderById(@PathVariable Long id) {
    orderService.deleteOrderById(id);
  }

  @PostMapping("/orders/update")
  public Order updateClient(@RequestBody Order order) {
    return orderService.updateOrder(order);
  }
}
