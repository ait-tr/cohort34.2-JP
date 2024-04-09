package de.ait.lesson06_dz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Account debit;
    private Account credit;
    private double amount;
}
