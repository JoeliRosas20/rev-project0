package com.training.pms.bank;

public class Transfer {
	
	private int transferId;
	private int userId;
	private int balance;
	private String person;
	
	public Transfer(int transferId, int userId, int balance, String person) {
		super();
		this.transferId = transferId;
		this.userId = userId;
		this.balance = balance;
		this.person = person;
	}

	public Transfer(int transferId, int userId, int balance) {
		super();
		this.transferId = transferId;
		this.userId = userId;
		this.balance = balance;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + transferId;
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
		Transfer other = (Transfer) obj;
		if (balance != other.balance)
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (transferId != other.transferId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transfer [transferId=" + transferId + ", userId=" + userId + ", balance=" + balance + ", person="
				+ person + "]";
	}
	
	public String toStringC() {
		return "Transfer [transferId=" + transferId + ", userId=" + userId + ", balance=" + balance + "]";
	}
	
}
