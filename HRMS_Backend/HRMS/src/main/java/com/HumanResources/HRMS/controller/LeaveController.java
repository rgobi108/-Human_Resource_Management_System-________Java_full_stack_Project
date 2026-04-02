package com.HumanResources.HRMS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HumanResources.HRMS.entity.Leave;
import com.HumanResources.HRMS.service.LeaveService;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService service;

    @PostMapping("/")
    public Leave apply(@RequestBody Leave leave) {
        return service.applyLeave(leave);
    }

    @PutMapping("/approve/{id}")
    public Leave approve(@PathVariable Long id) {
        return service.approveLeave(id);
    }
}