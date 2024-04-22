package com.andy.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private Long id;
    private String type;
    private String number;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private Client owner;


}