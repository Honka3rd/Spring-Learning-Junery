package com.spring.javaconfig.coaches;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

import com.spring.scopes.services.Service;

public class SwimCoach implements Coach {

	private Service service;

	@Value("${email}")
	private String email;

	@Value("${name}")
	private String name;

	public SwimCoach() {
	}

	public SwimCoach(Service s) {
		this.setService(s);
	}

	@Override
	public String getDailyWorkout() {

		return "Swim for 30 mins " + this.getEmail() + " " + this.getName();
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@PreDestroy
	public void destory() {
		System.out.println("Swim task accomplished");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
