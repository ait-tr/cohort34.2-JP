package de.ait.users.repositories;

import de.ait.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//                                         JpaRepository<сущность,тип id>
public interface UserJpaRepository extends JpaRepository<User,Long> {
}
