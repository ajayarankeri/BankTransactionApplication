package com.hcl.DemoBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.DemoBank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findByAccountNumber(long fromAccount);


}
