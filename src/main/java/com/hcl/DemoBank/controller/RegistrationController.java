package com.hcl.DemoBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.DemoBank.entity.Account;
import com.hcl.DemoBank.entity.UserRegister;
import com.hcl.DemoBank.service.BankService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	BankService BankService;
	
	@PostMapping("/user")
	public void registerUser(@RequestBody UserRegister register) {	
	   System.out.println("Registering.....");
	   BankService.registerUser(register);	   
	}
	
	@PostMapping("/creareAccount")
	public void CreateAccount(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {	
	   System.out.println("Account creating.....");
	   Account account=new Account();
	   UserRegister isUserExist = (UserRegister) BankService.checkUserExists(username, password);
	   account.setUserId(isUserExist.getUserId());
	   System.out.println(">>>>"+isUserExist.getUserId());
	   BankService.createNewAccount(account);
	  
		/*
		 * Account
		 * isAccountExist=(Account)BankService.checkAccountExists(isUserExist.getUserId(
		 * )); if(isAccountExist!=null) { System.out.println("Account is created");
		 * }else { BankService.createNewAccount(account); }
		 */
	   
	}

}
