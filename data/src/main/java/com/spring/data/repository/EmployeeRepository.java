package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("SELECT u FROM Employee u WHERE u.status = ?1")
    List<Employee> findEmployeeByStatus(Integer status);
    /*@Query(value = "SELECT * FROM Employee u WHERE u.status = ?1", nativeQuery = true)
    Employee findEmployeeByStatus(Integer status);*/

    /*@Query("SELECT u FROM Employee u WHERE u.status = ?1 AND u.firstName = ?2")
    List<Employee> findEmployeeByStatusAndFirstName(Integer status, String firstName);*/

    @Query("SELECT u FROM Employee u WHERE u.status = :status and u.firstName = :firstName")
    List<Employee> findEmployeeByStatusAndFirstName(@Param("status") Integer status, @Param("firstName") String firstName);

    /*@Query(value = "SELECT * FROM Employee u WHERE u.status = :status and u.firstName = :firstName", nativeQuery = true)
    List<Employee> findEmployeeByStatusAndFirstName(@Param("status") Integer status, @Param("firstName") String firstName);*/

    @Query(value = "SELECT u FROM Employee u WHERE u.firstName NOT IN :names")
    List<Employee> findEmployeeByFirstNameList(@Param("names") Collection<String> names);

    @Modifying
    @Query("UPDATE Employee u SET u.status = :status WHERE u.firstName = :name")
    int updateEmployeeSetStatusName(@Param("status") Integer status, @Param("name") String name);

    @Modifying
    @Query(value = "INSERT INTO Employee (firstName, lastName, salary, status) values (:firstName, :lastName, :salary, :status)", nativeQuery = true)
    void insertEmployee(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("salary") double salary, @Param("status") Integer status);

}
