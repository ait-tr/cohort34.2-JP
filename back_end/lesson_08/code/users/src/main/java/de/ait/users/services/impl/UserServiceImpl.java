package de.ait.users.services.impl;

import de.ait.users.model.User;
import de.ait.users.repositories.UserRepository;
import de.ait.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        //TODO check user exist
        repository.deleteById(id);
    }
}
