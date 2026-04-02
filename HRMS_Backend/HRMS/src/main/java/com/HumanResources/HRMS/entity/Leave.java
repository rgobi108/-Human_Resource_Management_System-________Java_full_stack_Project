package com.HumanResources.HRMS.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "`leave`")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long employeeId;
    private String fromDate;
    private String toDate;
    private String reason;
    private String status; // PENDING / APPROVED / REJECTED

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
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Leave(Long id, Long employeeId, String fromDate, String toDate, String reason, String status) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.status = status;
	}
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}