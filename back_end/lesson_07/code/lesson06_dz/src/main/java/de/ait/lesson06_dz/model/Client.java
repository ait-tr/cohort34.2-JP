package de.ait.lesson06_dz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Client {
    private Long id;
    private String name;
    private String email;
}