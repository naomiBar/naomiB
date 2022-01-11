package coupons.core;

import java.time.LocalDate;

import coupons.core.DBDao.ConnectionPool;
import coupons.core.DBDao.CouponsDBDao;
import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.beans.Customer;
import coupons.core.dao.CompaniesDao;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.facade.AdminFacade;
import coupons.core.facade.CompanyFacade;

public class Main {

	public static void main(String[] args) {

		try {
			
			AdminFacade adminFacade = new AdminFacade();
			adminFacade.addCompany(new Company(0, "nutella", "nutella@gmail", "1234"));
//			System.out.println("id: " + adminFacade.addCompany(null));
//			System.out.println("id: " + adminFacade.addCompany(new Company()));
//			System.out.println("id: " + adminFacade.addCompany(new Company(0, "Cola", "Cola@gmail", "1234")));
//			System.out.println("id: " + adminFacade.addCompany(new Company(0, "nutella", "nutella@gmail", "1234")));
//			System.out.println("id: " + adminFacade.addCompany(new Company(0, "nutella", "nutella@gmail", "1234")));
			adminFacade.updateCompany(new Company(1, "Cola", "", "1234"));
//			adminFacade.deleteCompany(5);
//			System.out.println(adminFacade.getOneCompany(4));
			System.out.println(adminFacade.getAllCompanies());
			
			
		    adminFacade.addCustomer(null);
			adminFacade.addCustomer(new Customer());
			adminFacade.addCustomer(new Customer(0, "naomi", "bar", "naomi@gmail.com", "0000"));
			adminFacade.addCustomer(new Customer(0, "naomi", "bar", "naomi@gmail.com", "0000"));
			adminFacade.addCustomer(new Customer(0, "odel", "levi", "naomi@gmail.com", "0000"));
			adminFacade.addCustomer(new Customer(0, "odel", "levi", "odel@gmail.com", "0000"));
			adminFacade.updateCustomer(new Customer(2, "odel", "levi", "odel@gmail.com", "1111"));
			System.out.println(adminFacade.getOneCustomer(1));
			System.out.println(adminFacade.getAllCustomers());
			
			
			CompanyFacade companyFacade = new CompanyFacade(adminFacade.getOneCompany(1));
			companyFacade.addCoupon(new Coupon(0, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
			companyFacade.addCoupon(new Coupon(0, 1, Category.FOOD, "car", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
			
//			CouponsDBDao couponsDBDao = new CouponsDBDao();
//			couponsDBDao.deleteCouponsOfCompany(1);
//			couponsDBDao.addCoupon(new Coupon(0, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//			couponsDBDao.addCoupon(new Coupon(0, 2, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//			couponsDBDao.addCoupon(new Coupon(0, 2, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//			couponsDBDao.addCoupon(new Coupon(0, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//			System.out.println("getOneCoupon: " + couponsDBDao.getOneCoupon(1));
//			couponsDBDao.updateCoupon(new Coupon(1, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 1000, 745.5, "fooooood"));
//			System.out.println("getOneCoupon: " + couponsDBDao.getOneCoupon(1));
//			couponsDBDao.deleteCoupon(1);
//			System.out.println("all: " + couponsDBDao.getAllCoupons());
			

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
