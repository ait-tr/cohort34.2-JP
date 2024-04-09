package de.ait.lesson06_dz.controller;

import de.ait.lesson06_dz.model.Account;
import de.ait.lesson06_dz.model.Transaction;
import de.ait.lesson06_dz.service.AccountService;
import de.ait.lesson06_dz.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;
    private final TransactionService transactionService;

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return service.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable(name = "id") Long accountID ){
        return service.getAccountByID(accountID);
    }

    //   accounts/1/transactions

    @GetMapping("/accounts/{accountIBAN}/transactions")
    public List<Transaction> getTransactionByAccount(@PathVariable String accountIBAN ){
        return transactionService.getTransactionByAccount(accountIBAN);
    }
}
