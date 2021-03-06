package com.Hibernate.SingleTable.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="USER_TABLE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	@Column(name="name")
	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
