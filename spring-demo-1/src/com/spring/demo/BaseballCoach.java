package com.spring.demo;

public class BaseballCoach implements Coach{
	
	FortuneService s;
	
	// literal field
	private String email;
	private String name;
	
	@Override
	public String getDailyWorkout() {
		return "30 mins baseball workout";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return s.getFortune();
	}

	public void setS(FortuneService s) {
		this.s = s;
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
