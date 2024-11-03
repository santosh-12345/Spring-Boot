package com.king;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.king.dao.exception.InsufficientAccountBalanceException;
import com.king.model.Account;
import com.king.service.BankService;
import com.king.service.impl.BankServiceImpl;

@SpringBootApplication
public class SpringBootJdbcTransactionManagementApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootJdbcTransactionManagementApplication.class, args);
		
		BankService bankService = ctx.getBean("bankServiceImpl", BankServiceImpl.class);
		Account fromAccount = new Account();
		fromAccount.setAccountNumber(1122330056L);

		Account toAccount = new Account();
		toAccount.setAccountNumber(3355330099L);

		try {
			bankService.transferFund(fromAccount, toAccount, 1000.00);
		} catch (InsufficientAccountBalanceException e) {
			e.printStackTrace();
		}
		ctx.close();
	}

}
