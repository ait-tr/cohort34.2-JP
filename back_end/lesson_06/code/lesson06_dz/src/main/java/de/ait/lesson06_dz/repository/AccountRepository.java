package de.ait.lesson06_dz.repository;

import de.ait.lesson06_dz.model.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();

}
