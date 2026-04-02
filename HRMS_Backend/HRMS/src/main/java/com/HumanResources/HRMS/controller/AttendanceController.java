package com.HumanResources.HRMS.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HumanResources.HRMS.entity.Attendance;
import com.HumanResources.HRMS.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/")
    public Attendance mark(@RequestBody Attendance att) {
        return service.save(att);
    }

    @GetMapping("/{empId}")
    public List<Attendance> getByEmployee(@PathVariable Long empId) {
        return service.getByEmployee(empId);
    }
}