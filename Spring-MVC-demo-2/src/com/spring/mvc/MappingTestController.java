package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MappingTest")
public class MappingTestController {
	
	@RequestMapping("/renderForm")
	public String index() {
		return "index";
	}

}
