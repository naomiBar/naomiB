package com.naomi.projects.bank;

public class PlatinumClient extends Client {

	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
		}

	@Override
	public String toString() {
		return "PlatinumClient [Id=" + getId() + "]";
	}

}
