package com.aop.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.before.dao.MembershipDAO;

import Configuration.DemoConfig;

public class MainAppTestorder {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		MembershipDAO memdao = context.getBean("membershipDAO", MembershipDAO.class);
		memdao.addMoney();
		
		context.close();
	}

}
