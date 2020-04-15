package com.aop.before.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccount() {
		System.out.println("Before add account:");
		System.out.println("----------:");
	}
	
	@Before("execution(public void com.aop.before.dao.MembershipDAO.add*())")
	public void beforeAddMemberAccount() {
		System.out.println("Before add Member account:");
		System.out.println("----------:");
	}
	
	@Before("execution(public String get*())")
	public void beforeGetAccountInfo() {
		System.out.println("Before get Member account infomation:");
		System.out.println("----------:");
	}
	
//	@Before("execution(public * add*(com.aop.before.Account, ..))")
//	public void beforeGetParmedAccount() {
//		System.out.println("Before get params:");
//		System.out.println("----------:");
//	}
}
