package com.hcl.DemoBank.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.DemoBank.entity.Account;
import com.hcl.DemoBank.entity.Transactions;
import com.hcl.DemoBank.entity.UserRegister;
import com.hcl.DemoBank.repository.AccountRepository;
import com.hcl.DemoBank.repository.BankRepository;
import com.hcl.DemoBank.repository.TransactionRepository;

@Service
public class BankService {
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public void registerUser(UserRegister userRegister) {		
		bankRepository.save(userRegister);
	}

	public UserRegister checkUserExists(String username,String password) {
		
		return bankRepository.findByUsernameAndPassword(username,password);
	}

	public void createNewAccount(Account acc) {		
		long accountNumber=generateRandomAccount();
		acc.setAccountNumber(accountNumber);
		acc.setBalance(100000.00);					
		bankRepository.save(acc);
	}
	
	public long generateRandomAccount() {
		long n = 1000000000 + new Random().nextInt();
		return n;
	}

	public Account checkAccountExists(long userId) {		
		return bankRepository.findByUserId(userId);
	}

	public String transferAmount(long fromAccount, long toAccount, double amount) {
		System.out.println("Called ==> From="+fromAccount+" to "+toAccount +" Amt="+amount);
		Account fromAcc=accountRepository.findByAccountNumber(fromAccount);
		Account toAcc=accountRepository.findByAccountNumber(toAccount);	
		
		System.out.println(fromAcc.getBalance());
		System.out.println(fromAcc.getAccountNumber());
		
		
		Transactions transactionDr = new Transactions();
		Transactions transactionCr = new Transactions();
		
		if(fromAcc.getBalance()>amount) {
			fromAcc.setBalance(fromAcc.getBalance()-amount);
			
			// transactionRepository.save(fromAcc);
			
			// Debit Transaction
			transactionDr.setAccountNumber(fromAccount);
			transactionDr.setTransactionAmount(amount);
			transactionDr.setTransactionType("DR");
			transactionDr.setTransactionDate(new Date());
			
			transactionRepository.save(transactionDr);
			
			// credit Transaction
			transactionCr.setAccountNumber(toAccount);
			transactionCr.setTransactionAmount(amount);
			transactionCr.setTransactionType("CR");
			transactionCr.setTransactionDate(new Date());
			
			transactionRepository.save(transactionCr);
			
			return "Amount Transfered";
		}else {
		return "Insufficient fund";
		}
	}

}
