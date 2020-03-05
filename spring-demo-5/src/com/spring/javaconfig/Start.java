package com.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.javaconfig.coaches.Coach;
import com.spring.javaconfig.coaches.SwimCoach;

public class Start {

	private static AnnotationConfigApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//Coach c = ctx.getBean("Tennis", Coach.class);
		
		//System.out.println(c.getDailyWorkout());
		
		SwimCoach sc = ctx.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(sc.getDailyWorkout());
		System.out.println(sc.getService().getService());
		
		ctx.close();
	}

}
