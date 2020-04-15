package com.aop.before.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class NetworkRequest {
	
	@Before("com.aop.before.order.SharedPointcuts.orderedlyExecute()")
	public void makeHTTPReq() {
		//System.out.println("2, sending encycled payment information");
	}

}
