package com.aop.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.before.dao.AccountDAO;
import com.aop.before.dao.MembershipDAO;

import Configuration.DemoConfig;

public class MainDemoApp {

	public static void main(String[] args) {

		// read config
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from container
		AccountDAO acc = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO mem = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call business method
		// acc.addAccount();
		// mem.addAccount();
		// mem.addMoney();
		System.out.println(acc.getAccountInfo());
		
		// close resource
		context.close();
	}

}
