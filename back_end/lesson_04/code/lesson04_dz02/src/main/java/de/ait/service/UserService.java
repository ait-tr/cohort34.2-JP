package de.ait.service;

import de.ait.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public boolean userValidate(User user);

    public User findUserByEmail(String email);
    public List<User> findBuNameStartingWith(String prefix);
}
