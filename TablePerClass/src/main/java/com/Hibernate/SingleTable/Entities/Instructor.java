package com.Hibernate.SingleTable.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "INSTRUCTOR_TABLE")
public class Instructor extends User {
	@Column(name="salary")
	private Integer salary;

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Instructor(String name, Integer salary) {
		super(name);
		this.salary = salary;
	}
	
	
}
