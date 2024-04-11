package de.ait.users.services;

import de.ait.users.dto.UserRequestDTO;
import de.ait.users.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserRequestDTO> findAll();
    List<UserRequestDTO> findAll(int age);
    Optional<User> findById(Long id);
    User add(User user);

    void deleteById(Long id);
}
