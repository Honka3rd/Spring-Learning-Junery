package com.aop.around.dao;

import org.springframework.stereotype.Component;

@Component
public class ExeceptionDAO {
	String[] errors = null;

	public ExeceptionDAO() {
		errors = new String[5];
	}

	public String[] getErrors() {
		return errors;
	}

	public void setErrors(String[] errors) {
		this.errors = errors;
	}
	
	public String getElement(int i) {
		return errors[i];
	}
	
	public String getFirstElement() {
		return errors[5];
	}
}
