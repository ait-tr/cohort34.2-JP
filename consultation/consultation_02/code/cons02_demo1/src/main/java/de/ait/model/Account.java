package de.ait.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Account {
    private Long id;
    private String iban;
    private double balance;
    private Person owner;
}
