package com.aop.after;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("accountDAO_after_finally")
public class AccountDAO {
	
	public List<Account> findAccounts(boolean triggerExeception){
		if(triggerExeception) {
			throw new RuntimeException("Exception is triggered");
		}
		
		List<Account> accs = new ArrayList<>();
		
		// create sample accounts
		Account acc_1 = new Account("A", 100);
		Account acc_2 = new Account("B", 200);
		Account acc_3 = new Account("C", 250);
		
		accs.add(acc_1);
		accs.add(acc_2);
		accs.add(acc_3);
		
		return accs;
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
