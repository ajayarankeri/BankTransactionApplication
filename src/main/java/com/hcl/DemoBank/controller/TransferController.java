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
	
	/**
	  * @desc This function will transfer amount from one account to another account. Debit & credit transaction will be inserted into transactions table
	  * @param long $fromAccount This will be from account 
	  * @param long $toAccount this will toAccount
	  * @param double $balance: This balance amount will be debit from fromAccount and the entry will be inserted into transactions table.
	*/	
	@PostMapping("/fromTo")
	public void transferAmount(@RequestParam(value = "fromAccount") long fromAccount,@RequestParam(value = "toAccount") long toAccount,@RequestParam(value = "amount") double amount) {
	 System.out.println("From="+fromAccount+" to "+toAccount +" Amt="+amount);
	 String result=	bankService.transferAmount(fromAccount,toAccount,amount);
	 
	}

}
