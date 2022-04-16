package com.paymentservice.pservice.controller;

import com.paymentservice.pservice.model.Client;
import com.paymentservice.pservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
  @Autowired ClientService clientService;

  @GetMapping("/clients")
  public List<Client> getAllClients() {
    return clientService.getAllClients();
  }

  @GetMapping("/clients/{id}")
  public Optional<Client> getClientById(@PathVariable Long id) {
    return clientService.getClientById(id);
  }

  @PostMapping("/clients/create")
  public Client createClient(@RequestBody Client client) {
    return clientService.createClient(client);
  }

  @DeleteMapping("/clients/{id}")
  public void deleteClientById(@PathVariable Long id) {
    clientService.deleteClientById(id);
  }

  @PostMapping("/clients/update")
  public Client updateClient(@RequestBody Client client) {
    return clientService.updateClient(client);
  }
}
