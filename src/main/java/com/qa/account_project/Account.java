package com.qa.account_project;

import org.json.JSONObject;

public class Account 
{

	private String firstName;
	private String lastName;
	private int accountNumber;
	
	private static int nextAvailableAccountNumber = 1;
	
	public Account(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		accountNumber = nextAvailableAccountNumber++;
	}
	
	public String toString()
	{
		return firstName + " " + lastName + " " + accountNumber;
	}
	
	public JSONObject toJSON()
	{
		return new JSONObject(this);	    
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public int getAccountNumber() 
	{
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) 
	{
		this.accountNumber = accountNumber;
	}
}
