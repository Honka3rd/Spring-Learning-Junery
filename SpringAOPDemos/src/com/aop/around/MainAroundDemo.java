package com.aop.around;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.around.service.TrafficFortuneService;

import Configuration.DemoConfig;

public class MainAroundDemo {
	
	private static AnnotationConfigApplicationContext context = null;
	private static Logger log = Logger.getLogger(MainAroundDemo.class.getName());
	
	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(DemoConfig.class);
				
		TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		// info can only og string
		log.info(service.getFortune());
		
		context.close();
	}
}
