package com.aop.before.declaration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DeclareAspect {
	
	private int uses = 0;
	
//	@Pointcut("execution (public * com.aop.before.dao.AccountDAO.*(..))")
//	public void unifiedFunction() {}
//	
//	@Before("unifiedFunction()")
//	public void test_1() {
//		uses += 1;
//		System.out.println(uses + " times");
//	}
//	
//	@Before("unifiedFunction()")
//	public void test_2() {
//		uses += 1;
//		System.out.println(uses + " times");
//	}
}
