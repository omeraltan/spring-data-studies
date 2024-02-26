package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL
    @Query("SELECT u FROM Employee u WHERE u.status = 1")
    Collection<Employee> findAllActiveEmployee();

    // Native
    @Query(value = "SELECT * FROM Employee u WHERE u.status IN (0,2,3)", nativeQuery = true)
    Collection<Employee> findAllNonActiveEmployee();

    @Query(value = "SELECT u FROM Employee u")
    List<Employee> findAllEmployees(Sort sort);

    @Query(value = "SELECT u FROM Employee u ORDER BY id")
    Page<Employee> findAllEmployeesWithPagination(Pageable pageable);

    @Query(value = "SELECT * FROM Employee ORDER BY id", countQuery = "SELECT COUNT(*) FROM Employee", nativeQuery = true)
    Page<Employee> findAllEmployeeWithPagination(Pageable pageable);



}
