package ua.bondarenkojek.services;

import ua.bondarenkojek.models.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void deleteById(Long id);

    User findById(Long id);

    User findByName(String name);

    User findUserByNameAndPassword(String name, String password);

    List<User> getAllUsers();

}
