package com.aop.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.before.dao.AccountDAO;

import Configuration.DemoConfig;

public class MainDemoJoinPoint {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accdao = context.getBean("accountDAO", AccountDAO.class);
		
		if(accdao != null) {
			System.out.println("dao is active");
			
			Account acc = new Account();
			acc.setBalance(200);
			acc.setName("Params");
			
			accdao.addAccount(acc, true);
		}
		
		if(context != null) {
			System.out.println("context is closed");
			context.close();
		}
		

	}

}
