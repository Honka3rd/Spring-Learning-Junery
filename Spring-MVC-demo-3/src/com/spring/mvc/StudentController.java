package com.spring.mvc;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/form")
public class StudentController {
	
	//AnnotationConfigApplicationContext ctx;
	
	//@PostConstruct
	//public void initContext() {
		//this.ctx = new AnnotationConfigApplicationContext(StudentConfigure.class);
	//}
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/renderForm")
	public String renderForm(Model model) {
		
		//student.addAttribute(ctx.getBean("student"));
		model.addAttribute("student", new Student());
		model.addAttribute("countries", countryOptions);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return "result";
	}
}
