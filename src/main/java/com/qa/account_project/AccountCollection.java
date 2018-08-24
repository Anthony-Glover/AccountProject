package com.qa.account_project;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class AccountCollection 
{
	private Map<Integer, Account> accountMap;
	
	public AccountCollection()
	{
		accountMap = new HashMap<Integer, Account>();
	}
	
	public class AccountCollectionIterator implements Iterator
	{
		private Iterator<Map.Entry<Integer, Account>> iter;
		
		public AccountCollectionIterator()
		{
			iter = accountMap.entrySet().iterator();
		}
		
		public boolean hasNext() 
		{
			return iter.hasNext();
		}

		public Account next() 
		{
			Map.Entry<Integer, Account> pair = (Map.Entry<Integer, Account>)iter.next();
			return (Account)pair.getValue();			
		}	
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
			accountMap.put(newAccount.getAccountNumber(), newAccount);
		}
	}
	
	public void removeAccount(int accountNumber) throws Exception
	{
		if (accountExists(accountNumber))
		{
			accountMap.remove(accountNumber);
		}
		else
		{
			// TODO: create specialised exception for this exception
			throw new Exception("Attempt to delete non-existing account");
		}		
	}
	
	public void removeAccount(Account accountToRemove) throws Exception
	{
		if (accountExists(accountToRemove.getAccountNumber()))
		{
			accountMap.remove(accountToRemove.getAccountNumber());
		}
		else
		{
			// TODO: create specialised exception for this exception
			throw new Exception("Attempt to delete non-existing account");
		}
	}
	
	public boolean accountExists(int accountNumber)
	{
		return accountMap.containsKey(accountNumber);
	}
	
	public Account find(int accountNumber)
	{
		return accountMap.get(accountNumber);
	}
	
	public boolean update(Account account)
	{
		if (null == accountMap.replace(account.getAccountNumber(), account))
			return false;
		else
			return true;
	}
	
	public JSONObject toJSON()
	{
		return new JSONObject(accountMap);	    
	}

	
	public AccountCollectionIterator iterator() 
	{
		return new AccountCollectionIterator();
	}

	public AccountCollection findByFirstName(String firstName) 
	{
		try 
		{
			return findBy(Account.class.getMethod("getFirstName"), firstName);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		return new AccountCollection();
	}

	public AccountCollection findByLastName(String lastName) 
	{
		try 
		{
			return findBy(Account.class.getMethod("getLastName"), lastName);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		return new AccountCollection();
	}
	
	public AccountCollection findBy(Method method, String compareString) 
	{
		AccountCollection resultAccountCollection  = new AccountCollection();
		
		AccountCollectionIterator iterator = iterator();
		
		while (iterator.hasNext()) 
	    {
			Account account = iterator.next();
			
	    	try 
	    	{
				if (compareString.equals(method.invoke(account)))
				{
					resultAccountCollection.addAccount(account);
				}
			} 
	    	catch (Exception e) 
	    	{
				e.printStackTrace();
			} 
	    }	
		return resultAccountCollection;
	}

	public int size()
	{
		return accountMap.size();
	}
}
