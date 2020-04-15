package com.aop.afterThrowing.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAfterThrowing {
	
	@AfterThrowing(
		pointcut="execution (public * com.aop.afterThrowing.dao.AccountDAO.findAccounts(..))",
		throwing="e"
			)
	public void responseThrowing(JoinPoint point, Exception e) {
		System.out.println("Aspect: no such index " + e);
	}
}
