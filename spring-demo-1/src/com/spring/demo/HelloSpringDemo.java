package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringDemo {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach c = context.getBean("myCoach", Coach.class); // pass class to check the bean type
		Coach bc = context.getBean("anotherCoach", Coach.class);
		
		// call method on the bean
		System.out.println(c.getDailyWorkout()); 
		System.out.println(bc.getDailyWorkout());
		System.out.println(bc.getFortune());
		System.out.println(c.getFortune());
		
		BaseballCoach c3 = context.getBean("myCoach", BaseballCoach.class);
		System.out.println(c3.getEmail());
		
		BasketballCoach btc = context.getBean("anotherCoach", BasketballCoach.class);
		System.out.println(btc.getEmail());
		// close the context
		context.close();
	}

}
