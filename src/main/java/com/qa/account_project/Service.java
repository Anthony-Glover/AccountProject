package com.qa.account_project;

public class Service 
{
	private AccountCollection accountCollection;
	
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

}
