package com.aop.after;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Configuration.DemoConfig;

public class MainAfterApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accdao = context.getBean("accountDAO_after_finally", AccountDAO.class);
		
		boolean triggerExeception = true;
		
		try {
			System.out.println("Main: " + accdao.findAccounts(triggerExeception));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		context.close();

	}

}
