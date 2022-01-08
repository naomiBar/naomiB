package coupons.core;

import coupons.core.DBDao.CompaniesDBDao;
import coupons.core.DBDao.ConnectionPool;
import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public class Main {

	public static void main(String[] args) {

		try {
//			ConnectionPool connectionPool = ConnectionPool.getInstance();
//			System.out.println(connectionPool);
			
//			Connection connection = connectionPool.getConnection(); //get connection from the pool
//			System.out.println("connection: " + connection);
//			connectionPool.restoreConnection(connection); //return connection to the pool
			
			CompaniesDBDao dbDao = new CompaniesDBDao();
			dbDao.addCompany(new Company(0, "naomi", "naomi@gmail", "1234"));
			System.out.println("isCompanyExists: " + dbDao.isCompanyExists("naomi@gmail", "1234"));
			
			dbDao.addCompany(new Company(0, "odel", "odel@gmail", "0000"));
			dbDao.updateCompany(new Company(2, "odel", "odel@gmail", "1111"));
			System.out.println(dbDao.getOneCompany(2));
			dbDao.deleteCompany(4);
			System.out.println(dbDao.getOneCompany(2));
			System.out.println("all: " + dbDao.getAllCompanies());
			

		} catch (CouponSystemException e) {
			System.out.println("EROR: " + e.getMessage());
			System.out.println("CAUSE: " + e.getCause());
		}
		finally {
			try {
				System.out.println("closeAllConnections:");
				ConnectionPool.getInstance().closeAllConnections();
				System.out.println("connectionPool down");
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}
		}
	}

}
