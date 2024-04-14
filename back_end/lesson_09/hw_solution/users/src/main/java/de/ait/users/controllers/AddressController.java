package de.ait.users.controllers;

import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;
import de.ait.users.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;


    @GetMapping
    public List<AddressRequestDTO> getAddresses(
            @RequestParam(required = false, defaultValue = "") String country,
            @RequestParam(required = false, defaultValue = "") String city,
            @RequestParam(required = false, defaultValue = "") String street) {
        List<Address> addresses = service.findAll(country, city, street);
        return AddressRequestDTO.from(addresses);
    }

    @GetMapping("/{id}")
    public AddressRequestDTO getAddressById(@PathVariable Long id) {
        Address address = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Address not found"));
        return AddressRequestDTO.from(address);
    }

    @PostMapping
    public void addNewAddress(@RequestBody AddressRequestDTO addressRequestDTO) {
        Address address = new Address(
                addressRequestDTO.getId(),
                addressRequestDTO.getCountry(),
                addressRequestDTO.getZipCode(),
                addressRequestDTO.getCity(),
                addressRequestDTO.getStreet(),
                addressRequestDTO.getHouseNumber()
        );
        service.add(address);
    }


    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable Long id, @RequestBody AddressRequestDTO updatedAddressDTO) {
        Address existingAddress = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Address not found"));
        existingAddress.setCountry(updatedAddressDTO.getCountry());
        existingAddress.setZipCode(updatedAddressDTO.getZipCode());
        existingAddress.setCity(updatedAddressDTO.getCity());
        existingAddress.setStreet(updatedAddressDTO.getStreet());
        existingAddress.setHouseNumber(updatedAddressDTO.getHouseNumber());
        service.update(existingAddress);
    }
}
