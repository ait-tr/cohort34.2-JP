package de.ait.users.repositories.impl;

import de.ait.users.model.User;
import de.ait.users.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>(List.of(
            new User(1525L, "Viktor", "viktor23", "vitja@gmail.com", 25),
            new User(1526L, "John", "john89", "john@gmail.com", 30),
            new User(1527L, "Alice", "alice99", "alice@gmail.com", 28),
            new User(1528L, "Bob", "bob321", "bob@gmail.com", 40),
            new User(1529L, "Emma", "emma75", "emma@gmail.com", 22),
            new User(1530L, "Michael", "mike789", "mike@gmail.com", 35),
            new User(1531L, "Sophia", "sophia11", "sophia@gmail.com", 26),
            new User(1532L, "David", "david44", "david@gmail.com", 33),
            new User(1533L, "Emily", "emily67", "emily@gmail.com", 29),
            new User(1534L, "Daniel", "daniel55", "daniel@gmail.com", 27)
    ));

    @Override
    public List<User> findAll() {

        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(u->u.getId().equals(id))
                .findAny();
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(u->u.getId().equals(id));
    }

}
