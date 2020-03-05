package com.spring.javaconfig;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.spring.javaconfig.coaches.Coach;
import com.spring.javaconfig.coaches.SwimCoach;
import com.spring.scopes.services.FortuneService;
import com.spring.scopes.services.Service;

@Configuration
//@ComponentScan("com.spring.javaconfig")
@PropertySource("classpath:resource")
public class SportConfig {
	
	@Bean
	public Coach swimCoach() {
		Coach sc = new SwimCoach(this.fortuneService());
		return sc;
	}

	@Bean
	public Service fortuneService() {
		Service s = new FortuneService();
		return s;
	}
}
