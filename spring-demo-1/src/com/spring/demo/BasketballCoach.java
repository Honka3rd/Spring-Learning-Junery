package com.spring.demo;

public class BasketballCoach implements Coach {
	
	FortuneService service;
	private String name;
	private String email;
	
	public BasketballCoach(FortuneService s) {
		this.service = s;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "play basketball for 30 min ";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return this.service.getFortune();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
