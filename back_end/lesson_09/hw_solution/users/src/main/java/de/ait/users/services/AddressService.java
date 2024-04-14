package de.ait.users.services;

import de.ait.users.model.Address;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll();

    List<Address> findAll(String country, String city, String street);

    Optional<Address> findById(Long id);

    Address add(Address address);

    void deleteById(Long id);

    void update(Address updatedAddress);
}
