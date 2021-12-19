package com.naomi.projects.bank;

public class Log {
	
	private long timestamp;
	private int clientId;
	private String description;
	private float amount;
	
	public Log(long timestamp, int clientId, String description, float amount) {
		super();
		this.timestamp = timestamp; //Currently the timestamp value sent to the Log constructor should be zero.
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}

	public String getData() {
		return "";
	}
}
