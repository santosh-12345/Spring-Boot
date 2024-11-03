package com.king.dao;

import com.king.dao.exception.InsufficientAccountBalanceException;
import com.king.model.Account;

public interface BankDao {
	public abstract void deposit(Account fromAccount,Account toAccount,Double amount);
	public abstract void withdraw(Account fromAccount,Account toAccount,Double amount) throws InsufficientAccountBalanceException;
}