package de.ait.lesson06_dz.controller;

import de.ait.lesson06_dz.model.Client;
import de.ait.lesson06_dz.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;
    private Client client = new Client(1L,"Jack", "jack@mail.com");

    // GET  localhost:8080\client
    @GetMapping("/client")
    public Client getClient(){
        return client;
    }

    @GetMapping("/clients")
    public List<Client> getClients(){
        return service.findAll();
    }

    //GET  localhost:8080/client/1
    @GetMapping("/clients/{id}")
    public Client getClients(@PathVariable Long id){
        return service.findById(id);
    }


}
