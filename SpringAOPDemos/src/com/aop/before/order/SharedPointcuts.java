package com.aop.before.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SharedPointcuts {
	@Pointcut("execution (public void com.aop.before.dao.MembershipDAO.addMoney())")
	public void orderedlyExecute() {}
	
	@Pointcut("execution (public void com.aop.before.dao.AccountDAO.addAccount(com.aop.before.Account, Boolean))")
	public void preloadParams() {}
}
