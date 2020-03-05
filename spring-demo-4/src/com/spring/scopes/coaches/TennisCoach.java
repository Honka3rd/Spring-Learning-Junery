package com.spring.scopes.coaches;

import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Tennis")
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {
	
	//private Service s;

	@Override
	public String getDailyWorkout() {
		return "play tennis for 30 mins";
	}
	
	@PostConstruct
	public void init() {
		System.out.println("component has been initialised");
	}
	
	//@PreDestroy
	//public void destory() {
	//	System.out.println("component has been destoried");
	//}

	@Override
	public void destroy() throws Exception {
		System.out.println("component has been destoried");
		
	}

}
