package com.HumanResources.HRMS.entity;

import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private String date;
    private String status; // PRESENT / ABSENT
    private String checkIn;
    private String checkOut;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public Attendance(Long id, Long employeeId, String date, String status, String checkIn, String checkOut) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.status = status;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}