package com.andy.example.demo.dto;

import com.andy.example.demo.entity.Card;
import com.andy.example.demo.entity.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class CardDto {
    private String type;
    private String number;


    public static Card toCard(CardDto dto){
        return Card.builder()
                .type(dto.getType())
                .number(dto.getNumber())
                .build();
    }
}