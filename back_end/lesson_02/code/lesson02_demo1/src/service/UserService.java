package service;

import model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public boolean userValidate(User user);
}
