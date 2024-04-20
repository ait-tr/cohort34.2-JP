package de.ait.users.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Schema(name = "AddressClass", description = "System address")
public class Address {

    @Schema(description = "address id", example = "123")
    private Long id;
    @Schema(description = "address country", example = "Deutschland")
    private String country;
    @Schema(description = "address zipCode", example = "123qwe")
    private String zipCode;
    @Schema(description = "address city", example = "Berlin")
    private String city;
    @Schema(description = "address id", example = "Berlin Street")
    private String street;
    @Schema(description = "address id", example = "12")
    private String house;

}
