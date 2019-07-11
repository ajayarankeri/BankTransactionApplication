package com.hcl.DemoBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.DemoBank.entity.UserRegister;
import com.hcl.DemoBank.service.BankService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	BankService BankService;

	@GetMapping("/validate")
	public ResponseEntity<UserRegister> userValidate(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		UserRegister isUserExist = (UserRegister) BankService.checkUserExists(username, password);       
		
	    if(isUserExist!=null) {
	    	System.out.println("Login Successfully");
	    }else {
	    	System.out.println("Wrong credentials");
	    }
		return new ResponseEntity<UserRegister>(isUserExist, HttpStatus.OK);
	   
		 

	}
}
