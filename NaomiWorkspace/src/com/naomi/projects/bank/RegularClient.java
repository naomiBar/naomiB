package com.naomi.projects.bank;

public class RegularClient extends Client {
	

	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
		super.commissionRate = 0.03F;
		super.interestRate = 0.001F;
		
	}

	@Override
	public String toString() {
		return "RegularClient [Id=" + getId() + "]";
	}

}
