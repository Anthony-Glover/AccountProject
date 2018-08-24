package com.qa.account_project;

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
	
	public AccountCollection find(int accountNumber, String firstName, String lastName)
	{
		AccountCollection resultAccountCollection  = new AccountCollection();
		
		if (0 < accountNumber) 
		{
			Account account = accountCollection.find(accountNumber);
			
			if ((null == firstName || "".equals(firstName) || firstName.equals(account.getFirstName())) && 
				(null == lastName || "".equals(lastName) || lastName.equals(account.getLastName())) &&
				null != account)
			{
				try 
				{
					resultAccountCollection.addAccount(account);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
			return resultAccountCollection;
		}
				
		if (null != firstName && !"".equals(firstName))
			resultAccountCollection = accountCollection.findByFirstName(firstName);
		
		if (null != lastName && !"".equals(lastName))
			return resultAccountCollection.findByLastName(lastName);
			
		return resultAccountCollection;
	}
	
	public boolean Update(Account account)
	{
		return accountCollection.update(account);
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

	public int findByLastNameCount(String lastName) 
	{		
		return accountCollection.findByLastName(lastName).size();
	}

	public int findByFirstNameCount(String firstName) 
	{		
		return accountCollection.findByFirstName(firstName).size();
	}
}
