package de.ait.lesson06_dz.service;

import de.ait.lesson06_dz.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findById(Long id);
}
