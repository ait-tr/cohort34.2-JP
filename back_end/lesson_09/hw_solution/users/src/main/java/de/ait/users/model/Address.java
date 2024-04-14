package de.ait.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    Long id;
    String country;
    String zipCode;
    String city;
    String street;
    String houseNumber;

}

