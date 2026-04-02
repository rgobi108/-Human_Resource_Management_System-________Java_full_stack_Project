package com.HumanResources.HRMS.entity;

import jakarta.persistence.*;
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String courseName;
    private Long employeeId;
    private String status;


    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Training(Long id, String courseName, Long employeeId, String status) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.employeeId = employeeId;
		this.status = status;
	}
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	
