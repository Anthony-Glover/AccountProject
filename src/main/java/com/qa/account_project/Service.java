package com.qa.account_project;

import java.util.Iterator;

import org.json.JSONObject;

import com.qa.account_project.AccountCollection.AccountCollectionIterator;

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

	public AccountCollectionIterator iterator()
	{
		return accountCollection.iterator();
	}

	public int findByFirstNameCount(String firstName) 
	{
		AccountCollectionIterator iterator = accountCollection.iterator();
		
		int count = 0;
		while (iterator.hasNext()) 
	    {
	    	Account account = iterator.next();
	    	
	    	if (firstName.equals(account.getFirstName()))
	    		count++;
	    }		
		return count;
	}
}
