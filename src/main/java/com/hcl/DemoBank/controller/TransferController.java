package com.hcl.DemoBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.DemoBank.service.BankService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	@Autowired
	BankService bankService;
	
	@PostMapping("/fromTo")
	public void transferAmount(@RequestParam(value = "fromAccount") long fromAccount,@RequestParam(value = "toAccount") long toAccount,@RequestParam(value = "amount") double amount) {
	 System.out.println("From="+fromAccount+" to "+toAccount +" Amt="+amount);
	 String result=	bankService.transferAmount(fromAccount,toAccount,amount);
	 
	}

}
