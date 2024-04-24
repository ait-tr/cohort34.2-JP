package com.andy.example.demo.controller;

import com.andy.example.demo.dto.CardDto;
import com.andy.example.demo.dto.ClientDto;
import com.andy.example.demo.entity.Card;
import com.andy.example.demo.entity.Client;
import com.andy.example.demo.repository.CardRepository;
import com.andy.example.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class Controller {
    private final ClientRepository clientRepository;
    private final CardRepository cardRepository;

    @GetMapping("/clients")
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{clientID}")
    public Client getClientById(@PathVariable Long clientID){
        return clientRepository.findById(clientID).get();
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody ClientDto client){
        return clientRepository.save(ClientDto.toClient(client));
    }

    @GetMapping("/cards")
    public List<Card> getAllCard(){
        return cardRepository.findAll();
    }

    @GetMapping("/cards/{cardId}")
    public Card getCardById(@PathVariable  Long cardId){
        return cardRepository.findById(cardId).get();
    }

    @PostMapping("/clients/{clientId}/cards")
    public Client addCardToClient(@PathVariable Long clientId, @RequestBody CardDto card){

        Client client = clientRepository.findById(clientId).get();

        Card newCard = CardDto.toCard(card);
        //newCard.getOwners().add(client);
        client.getCards().add(newCard);
        return clientRepository.save(client);
    }



}
