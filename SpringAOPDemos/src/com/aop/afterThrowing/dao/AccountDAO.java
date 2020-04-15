package com.aop.afterThrowing.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aop.afterThrowing.entity.Account;

@Component("accountDAO_throw")
public class AccountDAO {
	public Account findAccounts(int i){
		List<Account> accs = new ArrayList<>();
		
		// create sample accounts
		Account acc_1 = new Account("D", -100);
		Account acc_2 = new Account("E", -200);
		Account acc_3 = new Account("F", -250);
		
		accs.add(acc_1);
		accs.add(acc_2);
		accs.add(acc_3);
		
		return accs.get(i);
	}
	
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
