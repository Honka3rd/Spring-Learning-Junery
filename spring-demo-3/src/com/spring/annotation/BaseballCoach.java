package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("baseball")
public class BaseballCoach implements Coach{
		
	// literal field
	private String email;
	private String name;
	
	Service service;
	
	@Autowired
	public BaseballCoach(@Qualifier("fortuneService")Service s) {
		this.service = s;
	}
	
	@Override
	public String getDailyWorkout() {
		return "30 mins baseball workout";
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
	
	public void initBean() {
		System.out.println("Bean has been invoked");
	}
	
	public void destoryBean() {
		System.out.println("Bean has been destoried");
	}

	@Override
	public String getDailyFortune() {
		
		return this.service.getService();
	}
	
}
