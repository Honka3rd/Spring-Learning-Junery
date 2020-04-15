package com.aop.before.dao;

import org.springframework.stereotype.Component;

import com.aop.before.Account;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(this.getClass()+" is activated");
	}
	
	public void addAccount(Account acc, Boolean added) {
		System.out.println(acc + " " + added);
	}
	
	public String getAccountInfo() {
		return "account type: " + this.getClass();
	}

}
