package com.qa.account_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceTest 
{

	private static Service service;
	
	@Before
	public void setUp() throws Exception 
	{
    	service = new Service();
    	
    	Account newAccount = new Account("Tony", "Glover");
    	service.addAccount(newAccount);
    	newAccount = new Account("Seb", "Delaney");
    	service.addAccount(newAccount);
    	newAccount = new Account("Tony", "Jaa");
    	service.addAccount(newAccount);
    	newAccount = new Account("Tony", "Tiger");
    	service.addAccount(newAccount);
	}

	@Test
	public void test() 
	{
		assertEquals(3, service.findByFirstNameCount("Tony"));
	}

}
