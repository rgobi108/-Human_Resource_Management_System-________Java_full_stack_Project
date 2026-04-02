package com.HumanResources.HRMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HumanResources.HRMS.entity.Attendance;
import com.HumanResources.HRMS.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    public Attendance save(Attendance att) {
        return repo.save(att);
    }

    public List<Attendance> getByEmployee(Long empId) {
        return repo.findByEmployeeId(empId);
    }
}
