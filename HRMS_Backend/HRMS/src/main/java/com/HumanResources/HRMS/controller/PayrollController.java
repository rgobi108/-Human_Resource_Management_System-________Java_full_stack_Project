package com.HumanResources.HRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HumanResources.HRMS.entity.Payroll;
import com.HumanResources.HRMS.service.PayrollService;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService service;

    @PostMapping("/")
    public Payroll generate(@RequestBody Payroll payroll) {
        return service.generatePayroll(payroll);
    }

    @GetMapping("/{empId}")
    public List<Payroll> getPayroll(@PathVariable Long empId) {
        return service.getByEmployee(empId);
    }
}