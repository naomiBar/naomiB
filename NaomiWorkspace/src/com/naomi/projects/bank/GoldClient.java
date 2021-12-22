package com.naomi.projects.bank;

public class GoldClient extends Client {

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
		super.commissionRate = 0.02F;
		super.interestRate = 0.003F;
	}

	@Override
	public String toString() {
		return "GoldClient [Id=" + getId() + "]";
	}

}
