package de.ait.users.dto;

import de.ait.users.model.Address;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
@Builder

public class AddressRequestDTO {
    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;


    public static AddressRequestDTO from(Address address) {
        return AddressRequestDTO.builder()
                .city(address.getCity())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .houseNumber(address.getHouseNumber())
                .street(address.getStreet())
                .build();
    }

    public static List<AddressRequestDTO> from(List<Address> addresses) {
        return addresses.stream().map(AddressRequestDTO::from).collect(Collectors.toList());
    }
}
