package de.ait.repositories;

import de.ait.model.User;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User>{
    public List<User> findBuNameStartingWith(String prefix);
}
