package com.training.pms.bank;

public class Bank {
	
	private int userId;
	private int accountId;
	private int balance;

	public Bank() {
		// TODO Auto-generated constructor stub
	}

	public Bank(int userId, int accountId, int balance) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + balance;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (accountId != other.accountId)
			return false;
		if (balance != other.balance)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [userId=" + userId + ", accountId=" + accountId + ", balance=" + balance + "]";
	}

}
