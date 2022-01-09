package coupons.core;

import java.sql.Date;
import java.time.LocalDate;

import coupons.core.DBDao.CompaniesDBDao;
import coupons.core.DBDao.ConnectionPool;
import coupons.core.DBDao.CouponsDBDao;
import coupons.core.DBDao.CustomersDBDao;
import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class Main {

	public static void main(String[] args) {

		try {
//			ConnectionPool connectionPool = ConnectionPool.getInstance();
//			System.out.println(connectionPool);
			
//			Connection connection = connectionPool.getConnection(); //get connection from the pool
//			System.out.println("connection: " + connection);
//			connectionPool.restoreConnection(connection); //return connection to the pool
			
			
			CompaniesDBDao companiesDBDao = new CompaniesDBDao();
			System.out.println("id: " + companiesDBDao.addCompany(new Company(0, "maomi", "naomi@gmail", "1234")));
			System.out.println("id: " + companiesDBDao.addCompany(new Company(0, "talya", "talya@gmail", "1234")));
			System.out.println("id: " + companiesDBDao.addCompany(new Company(0, "odel", "odel@gmail", "1234")));
//			System.out.println("isCompanyExists: " + companiesDBDao.isCompanyExists("naomi@gmail", "1234"));
//			
//			companiesDBDao.addCompany(new Company(0, "odel", "odel@gmail", "0000"));
//			companiesDBDao.updateCompany(new Company(2, "odel", "odel@gmail", "1111"));
//			System.out.println(companiesDBDao.getOneCompany(2));
//			companiesDBDao.deleteCompany(2);
			System.out.println("all: " + companiesDBDao.getAllCompanies());
			
			
			CustomersDBDao customersDBDao = new CustomersDBDao();
//			customersDBDao.addCustomer(new Customer(0, "naomi", "bar", "naomi@gmail", "1234"));
//			System.out.println("isCustomerExists: " + customersDBDao.isCustomerExists("naomi@gmail", "1234"));
//			
//			customersDBDao.addCustomer(new Customer(0, "odel", "levi", "odek@gmail", "0000"));
//			customersDBDao.updateCustomer(new Customer(2, "odel", "cohen", "odel@gmail", "1111"));
//			System.out.println(customersDBDao.getOneCustomer(2));
//			customersDBDao.deleteCustomer(2);
			System.out.println("all: " + customersDBDao.getAllCustomers());
			
			
			CouponsDBDao couponsDBDao = new CouponsDBDao();
			couponsDBDao.addCoupon(new Coupon(0, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
			couponsDBDao.addCoupon(new Coupon(0, 2, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
			couponsDBDao.addCoupon(new Coupon(0, 2, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
			couponsDBDao.addCoupon(new Coupon(0, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//			System.out.println("getOneCoupon: " + couponsDBDao.getOneCoupon(1));
//			couponsDBDao.updateCoupon(new Coupon(1, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 1000, 745.5, "fooooood"));
//			System.out.println("getOneCoupon: " + couponsDBDao.getOneCoupon(1));
//			couponsDBDao.deleteCoupon(1);
			System.out.println("all: " + couponsDBDao.getAllCoupons());
			
//			couponsDBDao.addCouponPurchase(1, 2);
			couponsDBDao.deleteCouponPurchase(1, 2);

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
