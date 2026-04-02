package com.HumanResources.HRMS.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HumanResources.HRMS.dto.LoginDTO;
import com.HumanResources.HRMS.dto.SignupDTO;
import com.HumanResources.HRMS.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Signup endpoint
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody SignupDTO dto) {
        Map<String, Object> result = authService.signup(dto); // ✅ returns Map
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto) {
        Map<String, Object> tokenMap = authService.login(dto); // ✅ returns Map
        if (tokenMap == null || tokenMap.isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Invalid credentials"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(tokenMap, HttpStatus.OK);
    }
}