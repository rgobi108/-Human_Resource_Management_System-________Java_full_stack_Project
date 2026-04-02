package com.HumanResources.HRMS.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HumanResources.HRMS.entity.Payroll;
import com.HumanResources.HRMS.repository.PayrollRepository;


@Service
public class PayrollService {

    @Autowired
    private PayrollRepository repo;

    public Payroll generatePayroll(Payroll payroll) {
        double net = payroll.getBasicSalary()
                + payroll.getBonus()
                - payroll.getDeductions();

        payroll.setNetSalary(net);
        return repo.save(payroll);
    }

    public List<Payroll> getByEmployee(Long empId) {
        return repo.findByEmployeeId(empId);
    }
}
