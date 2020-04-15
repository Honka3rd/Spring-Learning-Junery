package com.aop.afterThrowing.entity;

public class Account {
	private String name;

	private float balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + "]";
	}

	public Account() {
	}

	public Account(String name, float balance) {
		this.name = name;
		this.balance = balance;
	}
}
