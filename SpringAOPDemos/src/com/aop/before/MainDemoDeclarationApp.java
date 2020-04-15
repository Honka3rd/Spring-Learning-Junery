package com.aop.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.before.dao.AccountDAO;

import Configuration.DemoConfig;

public class MainDemoDeclarationApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		
		account.addAccount();
		
		Account acc = new Account();
		acc.setBalance(100);
		acc.setName("declare");
		
		account.addAccount(acc, true);
		
		System.out.println(account.getAccountInfo());
	}

}
