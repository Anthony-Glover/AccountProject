package com.qa.account_project;

import java.util.Iterator;

import com.qa.account_project.AccountCollection.AccountCollectionIterator;

public class App 
{
	
	
    public static void main( String[] args )
    {
    	Service service;
    	service = new Service();
    	
    	Account newAccount = new Account("Tony", "Glover");
    	service.addAccount(newAccount);
    	newAccount = new Account("Seb", "Delaney");
    	service.addAccount(newAccount);
    	
    	Account existingAccount = service.find(newAccount.getAccountNumber());
    	System.out.println(existingAccount.toString());
    	
    	AccountCollectionIterator it = service.iterator();
	    while (it.hasNext()) 
	    {
	    	Account account = it.next();
	        System.out.println(account.toJSON());
	    }
	    
	    System.out.println(service.toJSON());

    	service.removeAccount(existingAccount);
    }
}
