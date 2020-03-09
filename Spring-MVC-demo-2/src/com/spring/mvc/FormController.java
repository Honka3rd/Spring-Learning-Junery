package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class FormController {

	// show form
	@RequestMapping("/renderForm")
	public String renderForm() {

		return "customer-info";
	}

	// process form
	@RequestMapping("/processForm")
	public String processForm() {

		return "result";
	}

	// read form data, add data to model
	@RequestMapping("/processData")
	public String processData(HttpServletRequest request, Model model) {

		String customerName = request.getParameter("customerName");

		String res = customerName.toUpperCase();

		model.addAttribute("result", res);

		return "index";
	}

	@RequestMapping("/autoProcessData")
	public String autoProcessData(@RequestParam("customerName") String customerName, Model model) {
		String res = customerName.toUpperCase();

		model.addAttribute("result", res);

		return "index";
	}

}
