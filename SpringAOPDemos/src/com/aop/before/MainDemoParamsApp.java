package com.aop.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.before.dao.AccountDAO;

import Configuration.DemoConfig;

public class MainDemoParamsApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		Account acc = new Account();
		acc.setName("costumer_1");
		acc.setBalance(300);
		
		AccountDAO acdao = context.getBean("accountDAO", AccountDAO.class);
		acdao.addAccount(acc, true);
		
		context.close();
	}

}
