package com.naomi.projects.bank;

public class Test {

	public static void main(String[] args) {

		Client client1 = new RegularClient(101, "Naomi", 150.5F);
		Client client2 = new GoldClient(0, "Naomi", 150.5F);
		Client client3 = new PlatinumClient(0, "Naomi", 150.5F);
		Bank bank = Bank.getInstance();
		bank.addClient(client1);
		bank.addClient(client2);
		bank.addClient(client3);
		bank.printClientList();
		System.out.println("===========================");
		bank.removeClient(101);
		bank.printClientList();
		System.out.println("===========================");
		bank.addClient(client3);
		bank.printClientList();
		System.out.println("===========================");
		
		Log log = new Log(0, 0, "aaa", 0);
		Logger logger = new Logger("Naomi");
		logger.log(log);
	}

}
