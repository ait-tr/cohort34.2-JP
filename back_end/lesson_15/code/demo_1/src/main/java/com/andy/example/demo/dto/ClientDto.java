package com.andy.example.demo.dto;

import com.andy.example.demo.entity.Card;
import com.andy.example.demo.entity.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientDto {
    private String name;

    public static Client toClient(ClientDto dto){
        return Client.builder().name(dto.name).build();
    }
}
