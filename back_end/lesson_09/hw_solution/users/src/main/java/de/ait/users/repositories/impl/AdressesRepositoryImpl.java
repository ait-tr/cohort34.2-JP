package de.ait.users.repositories.impl;

import de.ait.users.model.Address;
import de.ait.users.repositories.AdressesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class AdressesRepositoryImpl implements AdressesRepository {

    private final List<Address> addressList = new ArrayList<>(List.of(
            new Address(2L, "Estonia", "10111", "Tallinn", "Lossi plats", "15"),
            new Address(3L, "Germany", "10178", "Berlin", "Alexanderplatz", "41"),
            new Address(4L, "France", "75001", "Paris", "Champs-Élysées", "14"),
            new Address(5L, "Italy", "00184", "Rome", "Piazza di Spagna", "22"),
            new Address(6L, "Spain", "28001", "Madrid", "Gran Vía", "65"),
            new Address(7L, "United Kingdom", "SW1A 1AA", "London", "Buckingham Palace", "166"),
            new Address(8L, "United States", "90210", "Beverly Hills", "Rodeo Drive", "14"),
            new Address(9L, "Japan", "100-0001", "Tokyo", "Chiyoda", "132")
    ));

    @Override
    public List<Address> findAll() {
        return addressList;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressList.stream()
                .filter(a -> a.getId().equals(id))
                .findAny();
    }

    @Override
    public Address save(Address newAddress) {
        addressList.add(newAddress);
        return newAddress;
    }

    @Override
    public void deleteById(Long id) {
        addressList.removeIf(address->address.getId().equals(id));
        }

    @Override
    public void update(Address updatedAddress) {
        addressList.stream()
                .filter(a -> a.getId().equals(updatedAddress.getId()))
                .findFirst()
                .ifPresent(address -> {
                    address.setCountry(updatedAddress.getCountry());
                    address.setZipCode(updatedAddress.getZipCode());
                    address.setCity(updatedAddress.getCity());
                    address.setStreet(updatedAddress.getStreet());
                    address.setHouseNumber(updatedAddress.getHouseNumber());
                });
    }
}