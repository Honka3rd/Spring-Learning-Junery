package com.aop.afterRerurning.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.aop.afterReturing.entity.Account;

@Aspect
@Component
public class LoggingAfterReturing {
	
	@AfterReturning(
		pointcut="execution (public * com.aop.afterReturning.dao.AccountDAO.findAccounts())",
		returning="result"
			)
	public void logAfterReturing(JoinPoint point, List<Account> result) {
		System.out.println(this.getClass()+": method call success");
		System.out.println("Method name: "+point.getSignature());
		System.out.println("Result size: "+result.size());
	}
	
	@AfterReturning(
		pointcut="execution (public * com.aop.afterReturning.dao.AccountDAO.findAccounts())",
		returning="accounts"
			)
	public void capitaliseAccountName(List<Account> accounts) {
		if(accounts != null) {
			Account first = accounts.get(0);
			if(first != null) {
				first.setName(first.getName().toLowerCase());
			}
		}
	}
}
