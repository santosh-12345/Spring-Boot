package com.king.service;

import com.king.dao.exception.InsufficientAccountBalanceException;
import com.king.model.Account;

public interface BankService {
	public abstract void transferFund(Account fromAccount,Account toAccount,Double amount)throws InsufficientAccountBalanceException;
}