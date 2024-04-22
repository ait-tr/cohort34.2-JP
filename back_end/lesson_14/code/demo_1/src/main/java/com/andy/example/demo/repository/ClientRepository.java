package com.andy.example.demo.repository;

import com.andy.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
