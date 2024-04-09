package de.ait.lesson06_dz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Account {
    //создайте класс Account (Long id, String iban, double balance, Client owner)
    private Long id;
    private String iban;
    private double balance;
    private Client owner;
}