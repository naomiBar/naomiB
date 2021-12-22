package com.naomi.projects.bank;

import java.util.Objects;

public class Account {
	
	private int id;
	private float balance;
	
	public Account(int id, float balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		return id == other.id;
	}

	
	
	
}
