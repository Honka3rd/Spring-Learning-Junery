package com.aop.around.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingBetweenAround {
	
	Logger log = Logger.getLogger(LoggingBetweenAround.class.getName());
	
	@Around("execution (public * com.aop.around.service.TrafficFortuneService.getFortune(..))")
	public Object proceedFortune(ProceedingJoinPoint point) throws Throwable{
		
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object done = point.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();	
		
		long duration = end - begin;
		
		log.info("Durition: " + duration/1000.0 + "seconds");
		
		return done;
	}
	
	@Around("execution (public * com.aop.around.dao.ExeceptionDAO.getElement(..))")
	public Object handleDAOException(ProceedingJoinPoint point) throws Throwable {
		Object res = null;
		try {
			res = point.proceed();
		}catch(Exception e) {
			res = "None";
			log.warning("null pointer exeception has been handled");
		}
		
		return res;
	}
	
	@Around("execution (public * com.aop.around.dao.ExeceptionDAO.getFirstElement(..))")
	public Object rethrowException(ProceedingJoinPoint point) throws Throwable {
		Object res = null;
		try {
			res = point.proceed();
			return res;
		}catch(Exception e) {
			log.warning("an exception is thrown");
			throw e;
		}
	}
}
