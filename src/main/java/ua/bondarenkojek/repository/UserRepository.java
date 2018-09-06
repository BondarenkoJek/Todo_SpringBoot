package ua.bondarenkojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bondarenkojek.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUserName(String name);
    User getUserByUserNameAndPassword(String name, String password);
}
