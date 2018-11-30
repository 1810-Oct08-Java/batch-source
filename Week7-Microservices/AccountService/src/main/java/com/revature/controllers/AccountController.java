package com.revature.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	private Logger logger = Logger.getLogger(AccountController.class.getName());

	private List<Account> accounts = new ArrayList<>();
	
	public AccountController() {
		accounts.add(new Account(1,1,560.25));
		accounts.add(new Account(2,2,45.26));
		accounts.add(new Account(3,3,5090.43));
		accounts.add(new Account(4,2,14.89));
		accounts.add(new Account(5,2,320.97));
		accounts.add(new Account(6,3,12398.65));
	}
	
	@GetMapping
	public List<Account> getAllAccounts(){
		logger.info("AccountController.getAllAccounts()");
		return accounts;
	}
	
	@GetMapping("/{accountId}")
	public Account getAccountById(@PathVariable("accountId") int accountId) {
		logger.info("finding account by id "+accountId);
		for(Account a: accounts) {
			if(accountId == a.getAccountId()) {
				return a;
			}
		}
		return null;
	}
	
	@GetMapping("/customer/{customerId}")
	public List<Account> getAccountsByCustomerId(@PathVariable("customerId") int customerId){
		logger.info("finding accounts for customer id: "+customerId);
		return accounts.stream().filter(acct -> acct.getCustomerId() == customerId).collect(Collectors.toList());
	}
	
}
