package coupons.core.DBDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import coupons.core.exceptions.CouponSystemException;

public class ConnectionPool {

	private Set<Connection> connections = new HashSet<>();
	public static final int SIZE = 5;
	private boolean isOpen;

	private String dbUrl = "jdbc:mysql://localhost:3306/coupon_system";
	private String user = "root";
//	private String password = "1234";
	private String password = "Nbar2000";

	private static ConnectionPool instance;

	private ConnectionPool() throws SQLException {
		// create connections and add to the set
		for (int i = 0; i < SIZE; i++) {
			Connection connection = DriverManager.getConnection(dbUrl, user, password);
			connections.add(connection);
		}
		this.isOpen = true;
	}

	public static ConnectionPool getInstance() throws CouponSystemException {
		if (instance == null) {
			try {
				instance = new ConnectionPool();
			} catch (SQLException e) {
				throw new CouponSystemException("connection pool failed to start", e);
			}
		}
		return instance;
	}

	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * removes one Connection object from the repository and returns it by return so
	 * that it can be used to perform operations on the database.
	 * @return a connection object from the repository
	 * @throws CouponSystemException
	 */
	public synchronized Connection getConnection() throws CouponSystemException {
		if (!isOpen) {
			throw new CouponSystemException("getConnection failed - pool is closed");
		}
		while (connections.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Connection> it = this.connections.iterator();
		Connection connection = it.next();
		it.remove();
		return connection;
	}

	/**
	 * accepts as an argument one Connection object that has been vacated and
	 * returns it to the repository.
	 * @param connection
	 */
	public synchronized void restoreConnection(Connection connection) {
		this.connections.add(connection);
		notify();
		System.out.println("restoreConnection");
	}

	/**
	 * closes all Connections in terms of database.
	 * @throws CouponSystemException
	 */
	public synchronized void closeAllConnections() throws CouponSystemException {
		this.isOpen = false;
		// wait to all connections that return to the pool
		while (this.connections.size() < SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (Connection connection : connections) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new CouponSystemException("closeAllConnections failed", e);
			}
		}
		this.connections.clear();
	}

}
