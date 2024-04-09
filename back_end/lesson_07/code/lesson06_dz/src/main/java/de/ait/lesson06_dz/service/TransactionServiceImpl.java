package de.ait.lesson06_dz.service;

import de.ait.lesson06_dz.model.Account;
import de.ait.lesson06_dz.model.Transaction;
import de.ait.lesson06_dz.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository repository;
    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Transaction> getTransactionByAccount(String accountIBAN) {

        return findAll().stream()
                .filter(t->isTransactionWithAccount(t,accountIBAN))
                .collect(Collectors.toList());
    }

    private boolean isTransactionWithAccount(Transaction transaction, String accountIBAN){
        return  transaction.getDebit().getIban().equals(accountIBAN)|| transaction.getDebit().getIban().equals(accountIBAN);
    }

}
