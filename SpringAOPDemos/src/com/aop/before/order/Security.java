package com.aop.before.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class Security {
	
	@Before("com.aop.before.order.SharedPointcuts.orderedlyExecute()")
	public void securityCheck() {
		//System.out.println("1, scaning harmful software");
	}
}
