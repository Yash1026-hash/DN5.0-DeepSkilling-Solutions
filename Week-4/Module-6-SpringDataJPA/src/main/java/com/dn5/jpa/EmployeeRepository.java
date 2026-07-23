package com.dn5.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findBySalaryGreaterThan(double salary);

    List<Employee> findByDepartmentName(String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    List<Employee> findByEmailContaining(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> findBySalaryRange(double minSalary, double maxSalary);
}
