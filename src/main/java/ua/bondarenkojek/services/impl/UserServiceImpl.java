package ua.bondarenkojek.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.repository.UserRepository;
import ua.bondarenkojek.services.UserService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByName(String name) {
        return userRepository.getUserByUserName(name);
    }

    @Override
    public User findUserByNameAndPassword(String name, String password) {
        return userRepository.getUserByUserNameAndPassword(name, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
