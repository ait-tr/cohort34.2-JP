package de.ait.lesson06_dz.repository;

import de.ait.lesson06_dz.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    public List<Transaction> findAll();
    public Optional<Transaction> findById(Long id);
}
