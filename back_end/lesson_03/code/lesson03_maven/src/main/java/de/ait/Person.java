package de.ait;

import lombok.*;

@AllArgsConstructor (staticName = "of")
//@NoArgsConstructor
//@RequiredArgsConstructor    *
//@ToString    *
//@Getter     *
//@Setter     *
//@EqualsAndHashCode   *
@Data
@Builder


public class Person {
    private final String fName;
    private String lName;
    private int age;
}
