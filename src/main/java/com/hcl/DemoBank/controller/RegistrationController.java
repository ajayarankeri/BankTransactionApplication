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
	
	/**
	  * @desc This function will register user i.e. user will add in user table
	  * @param We are passing request body as input to insert register details
	*/	
	@PostMapping("/user")
	public void registerUser(@RequestBody UserRegister register) {	
	   System.out.println("Registering.....");
	   BankService.registerUser(register);	   
	}
	
	/**
	  * @desc This function will create an account with default balance with 10K and insert details in account table
	  * @param String $username this will be username which is inserted in register
	  * @param String $password this will be password which is inserted in register
	*/	
	@PostMapping("/creareAccount")
	public void CreateAccount(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {	
	   System.out.println("Account creating.....");
	   Account account=new Account();
	   UserRegister isUserExist = (UserRegister) BankService.checkUserExists(username, password);
	   account.setUserId(isUserExist.getUserId());
	   System.out.println(">>>>"+isUserExist.getUserId());
	   BankService.createNewAccount(account);
	   
	}

}
