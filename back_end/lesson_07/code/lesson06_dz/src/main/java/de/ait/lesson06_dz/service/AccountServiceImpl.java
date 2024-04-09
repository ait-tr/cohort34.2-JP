package de.ait.lesson06_dz.service;

import de.ait.lesson06_dz.model.Account;
import de.ait.lesson06_dz.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account getAccountByID(Long accountID) {
        return repository.findByID(accountID).orElse(null);
    }
}
