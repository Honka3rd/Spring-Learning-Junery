package com.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class FortuneService implements Service{

	@Override
	public String getService() {
		
		return "service offered";
	}

}
