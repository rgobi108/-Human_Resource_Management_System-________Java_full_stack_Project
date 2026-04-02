package com.HumanResources.HRMS.entity;

import jakarta.persistence.*;
@Entity
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long employeeId;
    private String review;
    private int rating;

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
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Performance(Long id, Long employeeId, String review, int rating) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.review = review;
		this.rating = rating;
	}
	public Performance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}