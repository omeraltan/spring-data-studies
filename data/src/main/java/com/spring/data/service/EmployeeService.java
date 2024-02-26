package com.spring.data.service;

import com.spring.data.entity.Employee;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Collection<Employee> findAllActiveEmployee();
    Collection<Employee> findAllNonActiveEmployee();
    List<Employee> findAllEmployees(Sort sort);

}
