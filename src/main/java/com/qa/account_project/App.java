package com.qa.account_project;

public class App 
{
	
	
    public static void main( String[] args )
    {
    	Service service;
    	service = new Service();
    	
    	Account newAccount = new Account("Tony", "glover");
    	service.addAccount(newAccount);
    	
    	Account existingAccount = service.find(newAccount.getAccountNumber());
    	System.out.println(existingAccount.toString());
    	service.removeAccount(existingAccount);
    }
}
