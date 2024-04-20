package de.ait.users.repositories;


import de.ait.users.model.Address;
import de.ait.users.model.User;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
  List<Address> findAll();
  Optional<Address> findById(Long id);
  Address save(Address address);

  void deleteById(Long id);


}
