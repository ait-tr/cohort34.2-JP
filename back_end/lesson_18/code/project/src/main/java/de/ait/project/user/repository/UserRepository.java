package de.ait.project.user.repository;

import de.ait.project.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByFirstName(String name);
}
