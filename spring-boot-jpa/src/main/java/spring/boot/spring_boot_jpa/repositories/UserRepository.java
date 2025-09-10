package spring.boot.spring_boot_jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.boot.spring_boot_jpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("Select u from User u join fetch u.tasks")
    List<User> getAllUsersWithTasks();
}
