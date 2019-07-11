package com.hcl.DemoBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.DemoBank.entity.Account;
import com.hcl.DemoBank.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{

	Account findByAccountNumber(long accountNumber);


}
