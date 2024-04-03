package de.ait.service;

import de.ait.repository.AccountRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    AccountRepository repository;
    PersonService personService;
}
