package spring.boot.spring_boot_jpa.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.boot.spring_boot_jpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Fetch users along with tasks (join fetch)
    @Query("SELECT u FROM User u JOIN FETCH u.tasks")
    List<User> getAllUsersWithTasks();

    // Paging: returns a page of users
    Page<User> findAll(Pageable pageable);

    // Sorting: returns all users sorted
    List<User> findAll(Sort sort);

    // Derived query example: find users by name (can also add paging or sorting)
    List<User> findByName(String name);

    List<User> findByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);

    // Limiting results using Spring Data JPA keywords
    User findFirstByOrderByIdAsc(); // first user by id

    User findTopByOrderByIdDesc(); // last user by id

    List<User> findTop3ByOrderByNameAsc(); // top 3 users sorted by name
}