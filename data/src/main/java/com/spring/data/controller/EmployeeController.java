package com.spring.data.controller;

import com.spring.data.entity.Employee;
import com.spring.data.repository.EmployeeRepository;
import com.spring.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/active")
    public ResponseEntity <Collection<Employee>> getAllActiveEmployee(){
        return new ResponseEntity<Collection<Employee>>(service.findAllActiveEmployee(), HttpStatus.OK);
    }

    @GetMapping("/nonactive")
    public ResponseEntity<Collection<Employee>> getAllNonactiveEmployee(){
        return new ResponseEntity<Collection<Employee>>(service.findAllNonActiveEmployee(), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> getAllEmployeeSort(){
        List<Employee> emp = repository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @GetMapping("/sortlength")
    public ResponseEntity<List<Employee>> getAllEmployeeSortLength(){
        List<Employee> emp = repository.findAllEmployees(JpaSort.unsafe("LENGTH(firstName)"));
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }
}
