package com.spring.mvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class Student {

	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String lang;
	
	private LinkedHashMap<String, String> langs;
	
	private String[] os;
	
	private ArrayList<String> favos;
	
	public Student() {
		langs = new LinkedHashMap<>();
		// key, value
		langs.put("Java", "Java");
		langs.put("Python", "Python");
		langs.put("JS", "JavaScript");
		
		os = new String[3];
		os[0] = "MAC";
		os[1] = "WIN";
		os[2] = "Linux";
		
		favos = new ArrayList<>();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getLangs() {
		return langs;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public ArrayList<String> getFavos() {
		return favos;
	}

	public void setFavos(ArrayList<String> favos) {
		this.favos = favos;
	}

	public String[] getOs() {
		return os;
	}

	public void setOs(String[] os) {
		this.os = os;
	}
	 
}
