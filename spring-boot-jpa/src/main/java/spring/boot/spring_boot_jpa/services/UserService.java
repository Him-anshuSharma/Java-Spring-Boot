package spring.boot.spring_boot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.spring_boot_jpa.entities.User;
import spring.boot.spring_boot_jpa.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean updateUser(int id, User newUser) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(newUser.getName());
            user.setTasks(newUser.getTasks());
            userRepository.save(user);
            return true;
        }

        return false; // User with given id not found
    }

    public List<User> getAllUsersWithTasks() {
        return userRepository.getAllUsersWithTasks();
    }

}
