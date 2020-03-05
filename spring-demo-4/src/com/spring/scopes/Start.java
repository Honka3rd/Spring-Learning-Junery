package com.spring.scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.scopes.coaches.Coach;

public class Start {

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach tc_1 = ctx.getBean("Tennis", Coach.class);
		
		//Coach tc_2 = ctx.getBean("Tennis", Coach.class);
		
		//System.out.println(tc_1.equals(tc_2));
		
		System.out.println(tc_1.getDailyWorkout());
		
		ctx.close();
	}

}
