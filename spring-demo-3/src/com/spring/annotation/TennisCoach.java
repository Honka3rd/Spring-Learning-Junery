package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Tennis")
public class TennisCoach implements Coach {
	
	private Service s;

	@Override
	public String getDailyWorkout() {
		return "play tennis for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		return s.getService();
	}

	public Service getS() {
		return s;
	}

	@Autowired
	public void setS(@Qualifier("anotherService")Service s) {
		this.s = s;
	}

}
