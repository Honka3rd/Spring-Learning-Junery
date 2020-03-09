package com.spring.mvc;


import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@RequestMapping("/renderForm")
	public String renderForm(Model model) {
		
		Customer c = new Customer();
		model.addAttribute("customer", c);
		
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult result
			) {
		System.out.println(result);
		if(result.hasErrors()) {
			return "customer-form";
		}
		return "comfirmation" ;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, trimmerEditor);
	}
}
