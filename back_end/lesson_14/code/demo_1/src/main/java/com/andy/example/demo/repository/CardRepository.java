package com.andy.example.demo.repository;

import com.andy.example.demo.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
