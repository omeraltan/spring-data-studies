package com.spring.data.service;

import com.spring.data.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Collection<Employee> findAllActiveEmployee();
    Collection<Employee> findAllNonActiveEmployee();
    List<Employee> findAllEmployees(Sort sort);
    List<Employee> findEmployeeByStatus(Integer status);
    List<Employee> findEmployeeByStatusAndFirstName(Integer status, String firstName);
    List<Employee> findEmployeeByFirstNameList(@Param("names") Collection<String> names);
    int updateEmployeeSetStatusName(@Param("status") Integer status, @Param("name") String name);

}
