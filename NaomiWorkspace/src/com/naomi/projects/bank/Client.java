package com.naomi.projects.bank;

public abstract class Client {

	private int id;
	private String name;
	private float balance;
	private Account[] accounts = new Account[5];
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

	public Account[] getAccounts() {
		return accounts;
	}

	/*
	 * add the account to the array and log the operation by creating Log object
	 * with appropriate data and sending it to the Logger.log(..) method.. You
	 * should seek the array and place the Account where the first null value is
	 * found.
	 */
	public void addAccount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = account;
				Log log = new Log(System.currentTimeMillis(), this.id, "add acoount" + account.getId(),
						account.getBalance());
				logger.log(log);
				return;
			}
		}
	}

	/* returns the account of the specified id or null if does not exist */
	public Account getAccount(int id) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getId() == id) {
				return accounts[i];
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
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accounts[i].getId() == id) {
				this.balance += accounts[i].getBalance();
				Log log = new Log(System.currentTimeMillis(), this.id, "remove account " + id,
						accounts[i].getBalance());
				logger.log(log);
				accounts[i] = null;
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
		Log log = new Log(System.currentTimeMillis(), this.id, "deposit to balance", amount);
		logger.log(log);
	}

	public void withdraw(float amount) {
		balance -= amount;
		Log log = new Log(System.currentTimeMillis(), this.id, "withdraw from balance", amount);
		logger.log(log);
	}

	/*
	 * run over the accounts, calculate the amount to add according to the client
	 * interest (meanwhile it is zero) and add it to each account balance. Use the
	 * interest data member in your calculation. Log this operation.
	 */
	public void autoUpdateAccounts() {

	}

	/* returns the sum of client balance + total account balance. */
	public float getFortune() {
		return balance;
	}
}
