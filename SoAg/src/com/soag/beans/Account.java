package com.soag.beans;

/*
 * Cette bean correspond aux comptes bancaires de la bdd.
 */
public class Account {
	
	private int account_id;
	private String account_customer_id; 
	private String account_balance;
	private String account_type;
	private int account_is_default;
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccount_customer_id() {
		return account_customer_id;
	}
	public void setAccount_customer_id(String account_customer_id) {
		this.account_customer_id = account_customer_id;
	}

	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getAccount_is_default() {
		return account_is_default;
	}
	public void setAccount_is_default(int account_is_default) {
		this.account_is_default = account_is_default;
	}
	public String getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(String account_balance) {
		this.account_balance = account_balance;
	}

}
