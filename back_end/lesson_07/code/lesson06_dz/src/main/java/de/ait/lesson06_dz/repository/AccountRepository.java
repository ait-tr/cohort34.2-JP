package de.ait.lesson06_dz.repository;

import de.ait.lesson06_dz.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll();

    Optional<Account> findByID(Long accountID);
}
