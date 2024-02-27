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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/status/{statusId}")
    public ResponseEntity<List<Employee>> getEmployeeWithStatus(@PathVariable(value = "statusId") Integer statusId){
        return new ResponseEntity<List<Employee>>(service.findEmployeeByStatus(statusId), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Employee>> getEmployeeWithStatusAndName(@RequestParam Integer statusId, @RequestParam String firstName){
        return new ResponseEntity<List<Employee>>(service.findEmployeeByStatusAndFirstName(statusId, firstName), HttpStatus.OK);
    }

    @GetMapping("status/notin") // http://localhost:8080/employee/status/notin?names=Ömer (NotIn)
    public ResponseEntity<List<Employee>> getEmployeeNotInList(@RequestParam Collection<String> names){
        return new ResponseEntity<List<Employee>>(service.findEmployeeByFirstNameList(names), HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity<List<Employee>> updateEmployees(@RequestParam(value = "statusId") Integer statusId, @RequestParam(value = "firstName") String firstName){
        service.updateEmployeeSetStatusName(statusId, firstName);
        List<Employee> emp = repository.findAll();
        return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }


}
