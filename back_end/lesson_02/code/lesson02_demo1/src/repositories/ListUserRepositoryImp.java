package repositories;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserRepositoryImp implements UserCrudRepository{
    private final List<User> users = new ArrayList<>();
    private Long currentID = 1L;


    @Override
    public void save(User user) {
        user.setId(currentID++);
        users.add(user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
        //return users;
    }

    @Override
    public User findByID(Long id) {
        return users.stream()
                .filter(u-> u.getId()==id.longValue())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(User element) {

    }

    @Override
    public void deleteByID(Long id) {

    }
}
