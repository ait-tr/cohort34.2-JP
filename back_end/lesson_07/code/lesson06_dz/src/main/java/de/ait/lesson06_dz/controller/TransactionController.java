package de.ait.lesson06_dz.controller;

import de.ait.lesson06_dz.model.Transaction;
import de.ait.lesson06_dz.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * GET /transactions  - все транзакции
 * GET /transactions/1  - транзакция c заданным id

* AccountController
 * GET /accounts/DE1000/transactions  - все транзакции в которых участвует счет с заданным IBAN

 */
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(){
        return service.findAll();
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransactions(@PathVariable  Long id){
        return service.findById(id);
    }
}
