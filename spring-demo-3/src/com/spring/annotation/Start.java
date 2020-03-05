package com.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach baseCoach = ctx.getBean("baseball", Coach.class);
		System.out.println(baseCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(baseCoach.getDailyFortune() + " by constructor");
		
		//get Tennis bean by id
		Coach tennisCoach  = ctx.getBean("Tennis", Coach.class);
		
		//get service through setter injection
		System.out.println(tennisCoach.getDailyFortune() + " by setter");
		
		ctx.close();
	}

}
