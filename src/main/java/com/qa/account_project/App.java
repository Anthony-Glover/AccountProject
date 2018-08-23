package com.qa.account_project;

import java.util.Iterator;

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
    	
	    Iterator it = service.iterator();
	    while (it.hasNext()) 
	    {
	    	Account account = (Account)it.next();
	        System.out.println(account.toJSON());
	    }
	    
	    System.out.println(service.toJSON());

    	service.removeAccount(existingAccount);
    }
}
