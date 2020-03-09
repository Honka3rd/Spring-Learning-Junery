package com.spring.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

	@NotNull(message="firstname is required")
	@Size(min=3, max=100, message="firstname should in the range of 3-100")
	private String firstName;
	
	@NotNull(message="lastname is required")
	private String lastName;
	
	@NotNull(message="number is required")
	@Min(value=1, message="should be greater than 1")
	@Max(value=10, message="should be smaller than 10")
	private Integer freePasses;
	// Integer: parse empty string/spaces to null so that trigger @NotNull
	
	@Size(min=5, max=5, message="5 chars/digits required")
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 digit(s)/char(s)")
	private String postalCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
