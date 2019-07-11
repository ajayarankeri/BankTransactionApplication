package com.hcl.DemoBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.DemoBank.entity.Account;
import com.hcl.DemoBank.entity.UserRegister;

public interface BankRepository extends JpaRepository<UserRegister, Long>{

	UserRegister findByUsernameAndPassword(String username, String password);

	void save(Account account);

	Account findByUserId(long userId);


}
