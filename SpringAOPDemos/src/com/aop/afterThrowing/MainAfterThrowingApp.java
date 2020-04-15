package com.aop.afterThrowing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.afterThrowing.dao.AccountDAO;

import Configuration.DemoConfig;

public class MainAfterThrowingApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		try {
			AccountDAO accdao = context.getBean("accountDAO_throw", AccountDAO.class);
			accdao.findAccounts(100);
		}
		catch(Exception e) {
			System.out.println("Main: the exeception should be captured");
		}
		
		context.close();
	}

}
