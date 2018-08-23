package com.qa.account_project;

import java.util.Iterator;

import org.json.JSONObject;

public class Service 
{
	private AccountCollection accountCollection;
	
	public Service()
	{
		accountCollection = new AccountCollection();
	}
	
	public void addAccount(Account newAccount)
	{
		try 
		{
			accountCollection.addAccount(newAccount);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeAccount(Account accountToRemove)
	{
		try 
		{
			accountCollection.removeAccount(accountToRemove);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Account find(int accountNumber)
	{
		return accountCollection.find(accountNumber);
	}
	
	public AccountCollection getAccountCollection() 
	{
		return accountCollection;
	}

	public JSONObject toJSON()
	{
		return accountCollection.toJSON();	    
	}

	public Iterator iterator()
	{
		return accountCollection.iterator();
	}
}
