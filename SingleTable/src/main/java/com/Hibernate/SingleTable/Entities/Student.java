package com.Hibernate.SingleTable.Entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TABLE")
@DiscriminatorValue(value = "STUDENT")
public class Student extends User {
	@Column(name="course")
	private String course;
	
	public Student(String name, String course ) {
		super(name);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	
}
