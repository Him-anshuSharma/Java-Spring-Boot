package student.management.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.management.application.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}