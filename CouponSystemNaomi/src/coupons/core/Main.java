package coupons.core;

import java.sql.Connection;

import coupons.core.dao.ConnectionPool;
import coupons.core.exceptions.CouponSystemException;

public class Main {

	public static void main(String[] args) {

		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			System.out.println(connectionPool);
			
			Connection connection = connectionPool.getConnection(); //get connection from the pool
			System.out.println("connection: " + connection);
			
			connectionPool.restoreConnection(connection); //return connection to the pool

		} catch (CouponSystemException e) {
			System.out.println("EROR: " + e.getMessage());
			System.out.println("CAUSE: " + e.getCause());
		}
		finally {
			try {
				ConnectionPool.getInstance().closeAllConnections();
				System.out.println("connectionPool down");
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}
		}
	}

}
