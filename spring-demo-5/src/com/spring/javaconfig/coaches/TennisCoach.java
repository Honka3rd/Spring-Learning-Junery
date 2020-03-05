package com.spring.javaconfig.coaches;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("Tennis")
public class TennisCoach implements Coach {
	
	//private Service s;

	@Override
	public String getDailyWorkout() {
		return "play tennis for 30 mins";
	}
	
	@PostConstruct
	public void init() {
		System.out.println("component has been initialised");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("component has been destoried");
	}

}
