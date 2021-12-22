package com.naomi.projects.bank;

public class Test {

	public static void main(String[] args) {

		Client client1 = new RegularClient(101, "Naomi", 150F);
		Client client2 = new GoldClient(0, "Naomi", 150.5F);
		Client client3 = new PlatinumClient(0, "Naomi", 150.5F);
		Client client4 = new PlatinumClient(0, "Naomi", 150.5F);
		System.out.println(client3.equals(client2));
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
		
		System.out.println(client1.getBalance());
		try {
			client1.withdraw(250F);
		} catch (WithdrawException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(client1.getBalance());
		
		Account account1 = new Account(1, 100F);
		client1.addAccount(account1);
		
	}

}
