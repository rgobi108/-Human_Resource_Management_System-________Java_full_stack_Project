package com.HumanResources.HRMS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HumanResources.HRMS.dto.LoginDTO;
import com.HumanResources.HRMS.dto.SignupDTO;
import com.HumanResources.HRMS.entity.Employee;
import com.HumanResources.HRMS.repository.EmployeeRepository;
import com.HumanResources.HRMS.security.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Signup
    public Map<String, Object> signup(SignupDTO dto) {
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setPassword(passwordEncoder.encode(dto.getPassword()));

        employeeRepository.save(emp);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User registered successfully");
        return response;
    }

    // Login
    public Map<String, Object> login(LoginDTO dto) {
        if (dto.getEmail() == null || dto.getPassword() == null) {
            throw new IllegalArgumentException("Email and password must not be null");
        }

        Optional<Employee> optionalEmp = employeeRepository.findByEmail(dto.getEmail());
        if (optionalEmp.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "User not found");
            return response;
        }

        Employee emp = optionalEmp.get();

        if (!passwordEncoder.matches(dto.getPassword(), emp.getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Invalid credentials");
            return response;
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(emp.getEmail());

        // Return JSON with token
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("email", emp.getEmail());
        response.put("name", emp.getName());
        return response;
    }
}