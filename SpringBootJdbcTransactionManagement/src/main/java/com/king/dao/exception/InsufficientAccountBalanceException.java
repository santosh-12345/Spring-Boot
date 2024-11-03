package com.king.dao.exception;

public class InsufficientAccountBalanceException extends Exception {

	private static final long serialVersionUID = 3058803366280513702L;

	public InsufficientAccountBalanceException(String message) {
		super(message);
	}
}
