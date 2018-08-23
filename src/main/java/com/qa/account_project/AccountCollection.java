package com.qa.account_project;

import java.util.HashMap;
import java.util.Map;

public class AccountCollection 
{
	private Map<Integer, Account> accountCollection;
	
	public AccountCollection()
	{
		accountCollection = new HashMap<Integer, Account>();
	}
	
	public void addAccount(Account newAccount) throws Exception
	{
		if (accountExists(newAccount.getAccountNumber()))
		{
			// TODO: create specialised exception for this exception
			throw new Exception("Account Already Exists");
		}
		else
		{
			accountCollection.put(newAccount.getAccountNumber(), newAccount);
		}
	}
	
	public void removeAccount(int accountNumber) throws Exception
	{
		if (accountExists(accountNumber))
		{
			accountCollection.remove(accountNumber);
		}
		else
		{
			// TODO: create specialised exception for this exception
			throw new Exception("Removing nonexisting account Exists");
		}		
	}
	
	public void removeAccount(Account accountToRemove) throws Exception
	{
		if (accountExists(accountToRemove.getAccountNumber()))
		{
			accountCollection.remove(accountToRemove.getAccountNumber());
		}
		else
		{
			// TODO: create specialised exception for this exception
			throw new Exception("Removing nonexisting account Exists");
		}
	}
	
	public boolean accountExists(int accountNumber)
	{
		return accountCollection.containsKey(accountNumber);
	}
	
	public Account find(int accountNumber)
	{
		return accountCollection.get(accountNumber);
	}
}
