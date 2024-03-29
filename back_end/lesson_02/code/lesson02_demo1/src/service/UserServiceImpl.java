package service;

import model.User;
import repositories.UserCrudRepository;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserCrudRepository repository;

    public UserServiceImpl(UserCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(User user) {
        if (userValidate(user)) {
            repository.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public boolean userValidate(User user) {
        return !user.getName().isEmpty() && user.getEmail().contains("@");
    }
}
