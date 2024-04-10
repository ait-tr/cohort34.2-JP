package de.ait.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private Long id;
    private String name;
    private String password;
    private String email;
    private int age;
}
