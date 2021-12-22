package com.naomi.projects.bank;

import java.util.LinkedList;
import java.util.List;

public class Bank {

	private List<Client> clients;
	private float balance; // bank monies from charged commissions.
	// private accountUpdater ;
	private Logger logger;

	private Bank() {
		clients = new LinkedList<>();
	}

	private static Bank instance = new Bank();

	public static Bank getInstance() {
		return instance;
	}

	public float getBalance() {
		return balance;
	}

	/*
	 * this operation returns the total bank fortune which is calculatedby summing
	 * the total clients balance and the total accounts balance – you should use
	 * Client.getFortune() method of each client.
	 */
	public float getTotalFortune() {
		float fortune = 0;
		for (Client client : clients) {
			fortune += client.getFortune();
		}
		return fortune;
	}

	/*
	 * add the client to the array and log the operation. You should seek the array
	 * and place the Client where the first null value is found.
	 */
	public void addClient(Client client) {
		clients.add(client);
		Log log = new Log(System.currentTimeMillis(), client.getId(), "add client", client.getBalance());
		Logger.log(log);
		
	}

	/*
	 * remove the client with the same id from the array (by assigning a 'null'
	 * value to the array[position]). Log the operation
	 */
	public void removeClient(int id) {
		for (Client client : clients) {
			if(client.getId() == id) {
				clients.remove(client);
				Log log = new Log(System.currentTimeMillis(), id, "remove client ", client.getBalance());
				Logger.log(log);
				return;
			}
		}
	}

	public List<Client> getClients() {
		return clients;
	}

	/* prints all logs that are stored in the logger – leave empty for now */
	public void viewLogs() {

	}

	public void startAccountUpdater() {

	}

	/*
	 * to update that bank balance by adding commission every-time client perform
	 * deposit and withdraw operations.
	 */
	public void addCommission(float commission) {
		this.balance += commission;
	}

	/*
	 * prints the client details using the new toString() implementation you'll
	 * create in the next part
	 */
	public void printClientList() {
		for (Client client : clients) {
			System.out.println(client);
		}
	}
}
