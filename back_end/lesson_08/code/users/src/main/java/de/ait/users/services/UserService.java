package de.ait.users.services;

import de.ait.users.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User add(User user);

    void deleteById(Long id);
}
