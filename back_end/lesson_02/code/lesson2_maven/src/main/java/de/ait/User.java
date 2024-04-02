package de.ait;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String name;
    private String email;
}
