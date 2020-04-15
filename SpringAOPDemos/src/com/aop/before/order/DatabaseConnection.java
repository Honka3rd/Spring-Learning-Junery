package com.aop.before.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class DatabaseConnection {
	
	@Before("com.aop.before.order.SharedPointcuts.orderedlyExecute()")
	public void modifyDBandResponse() {
		//System.out.println("3, database has been altered");
	}
}
