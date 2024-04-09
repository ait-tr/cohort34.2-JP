package de.ait.lesson06_dz.repository;

import de.ait.lesson06_dz.model.Account;
import de.ait.lesson06_dz.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private List<Account> accounts = List.of(
            new Account(1L,"DE0001",1000, new Client(1L,"Jack", "jack@mail.com")),
            new Account(2L,"DE0002",5000, new Client(2L,"Jack1", "jack1@mail.com")),
            new Account(5L,"DE0005",50, new Client(2L,"Jack1", "jack1@mail.com")),
            new Account(3L,"DE0003",3000.10, new Client(3L,"Jack2", "jack2@mail.com")),
            new Account(4L,"DE0004",100, new Client(4L,"Jack3", "jack3@mail.com"))
    );

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public Optional<Account> findByID(Long accountID) {
        return accounts.stream().filter(a->a.getId().equals(accountID)).findAny();
    }
}
