package com.aop.before.inorder;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Inordered {
	
//	@Pointcut("execution (public void com.aop.before.dao.MembershipDAO.addMoney())")
//	public void inorderedlyExecute() {}
//	
//	@Before("inorderedlyExecute()")
//	public void securityCheck() {
//		System.out.println("scaning harmful software");
//	}
//	
//	@Before("inorderedlyExecute()")
//	public void makeHTTPReq() {
//		System.out.println("sending encycled payment information");
//	}
//	
//	@Before("inorderedlyExecute()")
//	public void modifyDBandResponse() {
//		System.out.println("database has been altered");
//	}
}
