package de.ait.lesson06_dz.service;

import de.ait.lesson06_dz.model.Account;
import de.ait.lesson06_dz.model.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {
    public List<Transaction> findAll();
    public  Transaction findById(Long id);

    List<Transaction> getTransactionByAccount(String accountIBAN);
}
