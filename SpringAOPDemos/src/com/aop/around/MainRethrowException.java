package com.aop.around;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.around.dao.ExeceptionDAO;

import Configuration.DemoConfig;

public class MainRethrowException {

	private static AnnotationConfigApplicationContext context = null;
	private static Logger log = Logger.getLogger(MainAroundDemo.class.getName());
	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		ExeceptionDAO expdao = context.getBean("execeptionDAO", ExeceptionDAO.class);
		
		log.info(expdao.getFirstElement());
		
		context.close();

	}

}
