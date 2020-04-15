package com.aop.before.declaration;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CombinedDeclareAspect {
	
//	@Pointcut("execution (public * com.aop.before.dao.AccountDAO.add*(..))")
//	public void addPointcut() {}
//	
//	@Pointcut("execution (public * com.aop.before.dao.AccountDAO.get*(..))")
//	public void getPointcut() {}
//	
//	@Before("addPointcut() && !getPointcut()")
//	public void excuteExceptGetter() {
//		System.out.println("Only add functions get called");
//	}
}
