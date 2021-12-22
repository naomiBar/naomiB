package com.naomi.projects.bank;

import java.util.LinkedList;
import java.util.List;

public abstract class Client {

	private int id;
	private String name;
	private float balance;
	private List<Account> accounts = new LinkedList<>();
	protected float commissionRate = 0; // עמלה
	protected float interestRate = 0; // ריבית
	private Logger logger;

	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	// Constructor also instantiates the Logger
	public Client(int id, String name, float balance, Logger logger) {
		this(id, name, balance);
		this.logger = logger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	/*
	 * add the account to the array and log the operation by creating Log object
	 * with appropriate data and sending it to the Logger.log(..) method.. You
	 * should seek the array and place the Account where the first null value is
	 * found.
	 */
	public void addAccount(Account account) {
		accounts.add(account);
		Log log = new Log(System.currentTimeMillis(), this.id, "add acoount " + account.getId(),
				account.getBalance());
		Logger.log(log);
	}

	/* returns the account of the specified id or null if does not exist */
	public Account getAccount(int id) {
		for (Account account : accounts) {
			if(account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	/*
	 * remove the account with the same id from the array (by assigning a 'null'
	 * value to the array[position]) & transfers the money to the clients balance.
	 * Log the operation
	 */
	public void removeAccount(int id) {
		for (Account account : accounts) {
			if(account.getId() == id) {
				this.balance += account.getBalance();
				Log log = new Log(System.currentTimeMillis(), this.id, "remove account " + id,
						account.getBalance());
				Logger.log(log);
				accounts.remove(account);
				return;
			}
		}
	}

	/*
	 * deposit(float) & withdraw(float): void – implement to add or remove the
	 * amount from clients balance and charge for commission according to the
	 * commission rate (which is now zero). Use the commission data member in your
	 * calculation. Log these oprations.
	 */
	public void deposit(float amount) {
		balance += amount;
//		balance -= commissionRate * amount;
		Log log = new Log(System.currentTimeMillis(), this.id, "deposit to balance", amount);
		Logger.log(log);
	}

	public void withdraw(float amount) throws WithdrawException {
		if(amount<=this.balance) {
			balance -= amount;
			Bank.getInstance().addCommission(commissionRate * amount);
			balance -= commissionRate * amount;
			Log log = new Log(System.currentTimeMillis(), this.id, "withdraw from balance", amount);
			Logger.log(log);			
		}else {
			throw new WithdrawException("the amount to withdraw is greater than the current balance", this.id, this.balance, amount);
		}
	}

	/*
	 * run over the accounts, calculate the amount to add according to the client
	 * interest (meanwhile it is zero) and add it to each account balance. Use the
	 * interest data member in your calculation. Log this operation.
	 */
	public void autoUpdateAccounts() {
		for (Account account : accounts) {
			account.setBalance(account.getBalance() + interestRate);
			Log log = new Log(System.currentTimeMillis(), this.id,
					"update the amount of accoount " + account.getId(), account.getBalance());
			Logger.log(log);
		}
	}

	/* returns the sum of client balance + total account balance. */
	public float getFortune() {
		float fortune = this.balance;
		for (Account account : accounts) {
			fortune += account.getBalance();
		}
		return fortune;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Client)) {
			return false;
		}
		Client other = (Client)obj;
		return this.id == other.id;
	}	
	
	
}
