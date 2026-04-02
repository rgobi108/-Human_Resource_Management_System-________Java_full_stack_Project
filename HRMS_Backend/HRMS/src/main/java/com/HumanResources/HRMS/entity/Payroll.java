package com.HumanResources.HRMS.entity;

import jakarta.persistence.*;
@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long employeeId;
    private double basicSalary;
    private double bonus;
    private double deductions;
    private double netSalary;

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
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public Payroll(Long id, Long employeeId, double basicSalary, double bonus, double deductions, double netSalary) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.bonus = bonus;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}
	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}