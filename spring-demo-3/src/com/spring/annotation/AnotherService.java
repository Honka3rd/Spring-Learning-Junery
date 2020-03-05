package com.spring.annotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AnotherService implements Service {

	@Override
	public String getService() {
		int[] arr = {0,1,2,3};
		
		Random random = new Random();
		
		int num = random.nextInt(arr.length);
		
		return "This is another "+num+"th service";
	}

}
