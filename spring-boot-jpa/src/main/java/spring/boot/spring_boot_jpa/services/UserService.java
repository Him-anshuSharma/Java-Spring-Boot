package spring.boot.spring_boot_jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.boot.spring_boot_jpa.entities.User;
import spring.boot.spring_boot_jpa.repositories.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Fetch all users with tasks
    public List<User> getAllUsersWithTasks() {
        return userRepository.getAllUsersWithTasks();
    }

    // Paging
    public Page<User> getUsersWithPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    // Sorting
    public List<User> getUsersSorted(String sortBy) {
        return userRepository.findAll(Sort.by(sortBy));
    }

    // Paging + Sorting
    public Page<User> getUsersWithPagingAndSorting(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userRepository.findAll(pageable);
    }

    // Derived queries
    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUsersByNameSorted(String name, String sortBy) {
        return userRepository.findByName(name, Sort.by(sortBy));
    }

    public Page<User> getUsersByNamePaged(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findByName(name, pageable);
    }

    // Limiting
    public User getFirstUser() {
        return userRepository.findFirstByOrderByIdAsc();
    }

    public User getLastUser() {
        return userRepository.findTopByOrderByIdDesc();
    }

    public List<User> getTop3UsersByName() {
        return userRepository.findTop3ByOrderByNameAsc();
    }

    // CRUD operations
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean updateUser(int id, User user) {
        return userRepository.findById(id).map(existing -> {
            existing.setName(user.getName());
            return true;
        }).orElse(false);
    }

    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}