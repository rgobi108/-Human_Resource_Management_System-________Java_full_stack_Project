package com.HumanResources.HRMS.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HumanResources.HRMS.dto.SignupDTO;
import com.HumanResources.HRMS.entity.Employee;
import com.HumanResources.HRMS.service.EmployeeService;
import com.HumanResources.HRMS.service.AuthService;

@RestController
@RequestMapping("/employees")

@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    
    @Autowired
    private AuthService authService;
    
    // Create new employee
    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee emp) {
        Employee saved = service.save(emp);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get all employees
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = service.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        Employee emp = service.getById(id);
        if (emp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(Map.of("message", "Employee deleted"), HttpStatus.OK);
    }
   
    // Signup via EmployeeController
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody SignupDTO dto) {
        Map<String, Object> result = authService.signup(dto); // ✅ Map instead of String
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}