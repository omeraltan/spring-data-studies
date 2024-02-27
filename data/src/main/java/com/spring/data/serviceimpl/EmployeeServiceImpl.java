package com.spring.data.serviceimpl;

import com.spring.data.entity.Employee;
import com.spring.data.repository.EmployeeRepository;
import com.spring.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Collection<Employee> findAllActiveEmployee() {
        return repository.findAllActiveEmployee();
    }

    @Override
    public Collection<Employee> findAllNonActiveEmployee() {
        return repository.findAllNonActiveEmployee();
    }

    @Override
    public List<Employee> findAllEmployees(Sort sort) {
        return repository.findAllEmployees(sort);
    }

    @Override
    public List<Employee> findEmployeeByStatus(Integer status) {
        return repository.findEmployeeByStatus(status);
    }

    @Override
    public List<Employee> findEmployeeByStatusAndFirstName(Integer status, String firstName) {
        return repository.findEmployeeByStatusAndFirstName(status,firstName);
    }

    @Override
    public List<Employee> findEmployeeByFirstNameList(Collection<String> names) {
        return repository.findEmployeeByFirstNameList(names);
    }

    @Override
    public int updateEmployeeSetStatusName(Integer status, String name) {
        return repository.updateEmployeeSetStatusName(status, name);
    }
}
