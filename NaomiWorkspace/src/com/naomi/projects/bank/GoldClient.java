package com.naomi.projects.bank;

public class GoldClient extends Client {

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
	}

	@Override
	public String toString() {
		return "GoldClient [Id=" + getId() + "]";
	}

}
