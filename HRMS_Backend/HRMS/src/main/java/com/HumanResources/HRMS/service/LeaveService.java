package com.HumanResources.HRMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HumanResources.HRMS.entity.Leave;
import com.HumanResources.HRMS.repository.LeaveRepository;


@Service
public class LeaveService {

    @Autowired
    private LeaveRepository repo;

    public Leave applyLeave(Leave leave) {
        leave.setStatus("PENDING");
        return repo.save(leave);
    }

    public Leave approveLeave(Long id) {
        Leave leave = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus("APPROVED");
        return repo.save(leave);
    }
}
