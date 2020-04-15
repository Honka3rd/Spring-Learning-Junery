package com.aop.around;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.around.dao.ExeceptionDAO;

import Configuration.DemoConfig;

public class MainHandleExeception {

	private static AnnotationConfigApplicationContext context = null;
	private static Logger log = Logger.getLogger(MainAroundDemo.class.getName());
	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		ExeceptionDAO expdao = context.getBean("execeptionDAO", ExeceptionDAO.class);
		String s = expdao.getElement(5);
		log.info(s);
		context.close();

	}

}
