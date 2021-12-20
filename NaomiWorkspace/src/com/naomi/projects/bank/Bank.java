package com.naomi.projects.bank;

public class Bank {

	private Client[] clients = new Client[100];
	private float balance; // bank monies from charged commissions.
	// private accountUpdater ;
	private Logger logger;

	private Bank() {
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
		int sum = 0;
		for (int i = 0; i < clients.length; i++) {
			sum += clients[i].getFortune();
		}
		return sum;
	}

	/*
	 * add the client to the array and log the operation. You should seek the array
	 * and place the Client where the first null value is found.
	 */
	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				clients[i] = client;
				return;
			}
		}
	}

	/*
	 * remove the client with the same id from the array (by assigning a 'null'
	 * value to the array[position]). Log the operation
	 */
	public void removeClient(int id) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null && clients[i].getId() == id) {
				clients[i] = null;
				return;
			}
		}
	}

	public Client[] getClients() {
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

	}

	/*
	 * prints the client details using the new toString() implementation you'll
	 * create in the next part
	 */
	public void printClientList() {
		for (Client client : clients) {
			if(client!=null) {
				System.out.println(client);
			}
		}
	}
}
