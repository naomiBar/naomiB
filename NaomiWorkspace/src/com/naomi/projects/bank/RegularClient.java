package com.naomi.projects.bank;

public class RegularClient extends Client {

	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
	}

	@Override
	public String toString() {
		return "RegularClient [Id=" + getId() + "]";
	}

}
