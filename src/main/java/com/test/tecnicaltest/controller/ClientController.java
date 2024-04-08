package com.test.tecnicaltest.controller;
import com.test.tecnicaltest.entity.Client;
import com.test.tecnicaltest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client/")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Client> getAll() {
        return clientService.getClients();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable("id") int id) {
        return clientService.getClient(id);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public Client create(@RequestBody Client client) {
        return clientService.saveOrUpdate(client);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        clientService.deleteClient(id);
    }
}
