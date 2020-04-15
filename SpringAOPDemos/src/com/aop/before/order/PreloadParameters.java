package com.aop.before.order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PreloadParameters {
	
	@Before("com.aop.before.order.SharedPointcuts.preloadParams()")
	public void displayArgs(JoinPoint point) {
		Object[] args = point.getArgs();
		System.out.println("args:");
		if(args != null) {
			
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				System.out.println(arg);
			}
		}
	}
	
	@Before("com.aop.before.order.SharedPointcuts.preloadParams()")
	public void displaySignature(JoinPoint point) {
		MethodSignature sig = (MethodSignature)point.getSignature();
		System.out.println("Method: " + sig.toString());
	}

}
