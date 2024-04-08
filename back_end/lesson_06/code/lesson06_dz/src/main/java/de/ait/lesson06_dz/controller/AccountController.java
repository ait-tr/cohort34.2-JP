package de.ait.lesson06_dz.controller;

import de.ait.lesson06_dz.model.Account;
import de.ait.lesson06_dz.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return service.findAll();
    }

}
