package com.aop.afterReturing;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.afterReturning.dao.AccountDAO;
import com.aop.afterReturing.entity.Account;

import Configuration.DemoConfig;

public class MainAfterReturningApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accdao = context.getBean("accountDAO_after", AccountDAO.class);
		
		List<Account> accs = accdao.findAccounts();
		
		System.out.println("Accounts:");
		System.out.println(accs);
		
		context.close();
	}

}
