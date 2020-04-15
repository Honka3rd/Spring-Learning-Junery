package com.aop.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAfterFinally {
	
	@After("execution (public * com.aop.after.AccountDAO.findAccounts(..))")
	public void runBeforeFinally(JoinPoint point) {
		System.out.println(point.getSignature().toShortString());
		System.out.println("Thing's finally done, whatever");
	}
}
