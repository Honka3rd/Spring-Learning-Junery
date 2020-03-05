package com.spring.demo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		String[] flist = {"a", "b", "c"};
		
		return flist[(int) (Math.random()*flist.length)];
	}

}
