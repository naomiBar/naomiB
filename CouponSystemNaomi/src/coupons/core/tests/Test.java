package coupons.core.tests;

import java.time.LocalDate;

import coupons.core.CouponExpirationDailyJob;
import coupons.core.DBDao.ConnectionPool;
import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.facade.AdminFacade;
import coupons.core.facade.ClientFacade;
import coupons.core.facade.CompanyFacade;
import coupons.core.facade.CustomerFacade;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;

public class Test {

	public static void testall() {
		CouponExpirationDailyJob dailyJob = null;
		try {
			dailyJob = new CouponExpirationDailyJob();

			LoginManager loginManager = LoginManager.getInstance();
			dailyJob.startDailyJob();

			testAdmin(loginManager);
			testCompany(loginManager);
			testCustomer(loginManager);

		} catch (CouponSystemException e) {
			System.err.println("EROR: " + e.getMessage());
			System.err.println("CAUSE: " + e.getCause());
		} finally {
			try {
				System.out.println("\n>>> coupon system shutdown in 5 seconds");
				Thread.sleep(5000);
				if(dailyJob!=null) {
					dailyJob.stopDailyJob();
				}
				
				System.out.println("closeAllConnections:");
				ConnectionPool.getInstance().closeAllConnections();
				System.out.println("connectionPool down");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void testAdmin(LoginManager loginManager) throws CouponSystemException {
		System.out.println("\t admin:");
		ClientFacade facade = loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
		if (facade instanceof AdminFacade) {
			AdminFacade adminFacade = (AdminFacade) facade;
			int id = adminFacade.addCompany(new Company(0, "nutella", "nutella@gmail.com", "1234"));
			id = adminFacade.addCompany(new Company(0, "Cola", "cola@gmail.com", "1234"));
			adminFacade.updateCompany(new Company(id, "cola", "cola@gmail.com", "0000"));
			System.out.println("company: " + adminFacade.getOneCompany(id));
			adminFacade.deleteCompany(id);
			System.out.println("allCompanies: " + adminFacade.getAllCompanies());

			id = adminFacade.addCustomer(new Customer(0, "naomi", "bar", "naomi@gmail.com", "0000"));
			id = adminFacade.addCustomer(new Customer(0, "odel", "levi", "odel@gmail.com", "0000"));
			adminFacade.updateCustomer(new Customer(id, "odel", "bar", "odel@gmail.com", "0000"));
			System.out.println("customer: " + adminFacade.getOneCustomer(id));
			adminFacade.deleteCustomer(id);
			System.out.println("allCustomers: " + adminFacade.getAllCustomers());
		}
	}

	public static void testCompany(LoginManager loginManager) throws CouponSystemException {
		System.out.println("\n\t company:");
		ClientFacade facade = loginManager.login("nutella@gmail.com", "1234", ClientType.COMPANY);
		if (facade instanceof CompanyFacade) {
			CompanyFacade companyFacade = (CompanyFacade) facade;
			int id = companyFacade.addCoupon(new Coupon(0, 1, Category.TRAVEL, "vaction to Eilat", "a weekend at the Dan Hotel includes a flight for NIS 1,000", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 1000, "vactionnnn"));
			companyFacade.updateCoupon(new Coupon(id, 1, Category.TRAVEL, "vaction to Eilat", "a weekend at the Dan Hotel includes a flight for NIS 1,000", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 8, 1), 500, 1000, "vactionnnn"));
			id = companyFacade.addCoupon(new Coupon(0, 1, Category.FOOD, "food for life", "good food for good life",
					LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 20), 500, 658.5, "fooooood")); //will be fail because the end date
//			companyFacade.deleteCoupon(1);
			System.out.println("getCompanyCoupons: " + companyFacade.getCompanyCoupons());
			System.out.println("getCompanyCoupons by category: " + companyFacade.getCompanyCoupons(Category.FOOD));
			System.out.println("getCompanyCoupons by maxPrice: " + companyFacade.getCompanyCoupons(1000));
			System.out.println("getCompanyDetails: " + companyFacade.getCompanyDetails());
		}
	}

	public static void testCustomer(LoginManager loginManager) throws CouponSystemException {
		System.out.println("\n\t customer:");
		ClientFacade facade = loginManager.login("naomi@gmail.com", "0000", ClientType.CUSTOMER);
		if (facade instanceof CustomerFacade) {
			CustomerFacade customerFacade = (CustomerFacade) facade;
			customerFacade.purchaseCoupon(new Coupon(1, 1, Category.TRAVEL, "vaction to Eilat", "a weekend at the Dan Hotel includes a flight for NIS 1,000", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 8, 1), 500, 1000, "vactionnnn"));
			customerFacade.purchaseCoupon(new Coupon(2, 1, Category.FOOD, "food for life", "good food for good life",
					LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 20), 500, 658.5, "fooooood")); //will be fail because the coupon not exist	
			System.out.println("getCustomerCoupons: " + customerFacade.getCustomerCoupons());
			System.out.println("getCustomerCoupons by category: " + customerFacade.getCustomerCoupons(Category.FOOD));
			System.out.println("getCustomerCoupons by maxPrice: " + customerFacade.getCustomerCoupons(1000));
			System.out.println("getCustomerDetails: " + customerFacade.getCustomerDetails());
		}
	}
}
