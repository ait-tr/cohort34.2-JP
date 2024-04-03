package de.ait.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
//@EqualsAndHashCode(of={"id"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @EqualsAndHashCode.Include  private Long id;
    private String name;
    private String email;



    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }






}

