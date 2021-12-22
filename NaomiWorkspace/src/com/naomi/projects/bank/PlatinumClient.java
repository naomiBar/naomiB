package com.naomi.projects.bank;

public class PlatinumClient extends Client {

	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
		super.commissionRate = 0.01F;
		super.interestRate = 0.005F;
	}

	@Override
	public String toString() {
		return "PlatinumClient [Id=" + getId() + "]";
	}
	
	

}
