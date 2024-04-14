package de.ait.users.services.impl;

import de.ait.users.model.Address;
import de.ait.users.repositories.AdressesRepository;
import de.ait.users.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AdressesRepository repository;

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Address> findAll(String country, String city, String street) {
        List<Address> addresses = repository.findAll();

        return addresses.stream()
                .filter(address -> (country.isEmpty() || address.getCountry().equalsIgnoreCase(country)))
                .filter(address -> (city.isEmpty() || address.getCity().equalsIgnoreCase(city)))
                .filter(address -> (street.isEmpty() || address.getStreet().equalsIgnoreCase(street)))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Address add(Address address) {
        return repository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Address> optionalAddress = repository.findById(id);
        optionalAddress.ifPresent(address -> {
            if (address != null) {
                repository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Address not found for id: " + id);
            }
        });
    }

    @Override
    public void update(Address updatedAddress) {
        Optional<Address> optionalAddress = repository.findById(updatedAddress.getId());
        optionalAddress.ifPresent(address -> {
            address.setCountry(updatedAddress.getCountry());
            address.setZipCode(updatedAddress.getZipCode());
            address.setCity(updatedAddress.getCity());
            address.setStreet(updatedAddress.getStreet());
            address.setHouseNumber(updatedAddress.getHouseNumber());
            repository.update(address);
        });
    }
}

