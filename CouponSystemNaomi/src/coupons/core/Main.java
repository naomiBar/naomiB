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
import coupons.core.facade.ClientFacade;
import coupons.core.facade.ClientType;
import coupons.core.facade.CompanyFacade;
import coupons.core.facade.CustomerFacade;
import coupons.core.facade.LoginManager;

public class Main {

	public static void main(String[] args) {

		try {
			LoginManager loginManager = LoginManager.getInstance();
			
			//ADMIN
			ClientFacade facade = loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
			if(facade != null) {
				System.out.println("name: " + facade.getClass());								
			}
			if(facade instanceof AdminFacade) {
				AdminFacade adminFacade = (AdminFacade)facade;
//				int id = adminFacade.addCompany(new Company(0, "nutella", "nutella@gmail", "1234"));
//				id = adminFacade.addCompany(new Company(0, "Cola", "cola@gmail", "1234"));
//				adminFacade.updateCompany(new Company(id, "cola", "cola@gmail", "0000"));
//				adminFacade.deleteCompany(1);
//				System.out.println(adminFacade.getOneCompany(id));
//				adminFacade.deleteCompany(2);
				System.out.println(adminFacade.getAllCompanies());
				
//				id = adminFacade.addCustomer(new Customer(0, "naomi", "bar", "naomi@gmail.com", "0000"));
//				id = adminFacade.addCustomer(new Customer(0, "odel", "levi", "odel@gmail.com", "0000"));
//				adminFacade.updateCustomer(new Customer(id, "odel", "bar", "odel@gmail.com", "0000"));
//				System.out.println(adminFacade.getOneCustomer(id));
//				adminFacade.deleteCustomer(id);
				System.out.println(adminFacade.getAllCustomers());
			}
			
			//COMPANY
			facade = loginManager.login("cola@gmail", "0000", ClientType.COMPANY);
			if(facade != null) {
				System.out.println("name: " + facade.getClass());								
			}
			if(facade instanceof CompanyFacade) {
				CompanyFacade companyFacade = (CompanyFacade)facade;
//				int id = companyFacade.addCoupon(new Coupon(0, 2, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//				companyFacade.updateCoupon(new Coupon(id, 2, Category.FOOD, "cola is good for life", "good cola for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//				companyFacade.deleteCoupon(1);
				System.out.println("getCompanyCoupons: " + companyFacade.getCompanyCoupons());
				System.out.println("getCompanyCoupons by category: " + companyFacade.getCompanyCoupons(Category.FOOD));
				System.out.println("getCompanyCoupons by maxPrice: " + companyFacade.getCompanyCoupons(300));
				System.out.println("getCompanyDetails: " + companyFacade.getCompanyDetails());
			}
			
			//CUSTOMER
			facade = loginManager.login("naomi@gmail.com", "0000", ClientType.CUSTOMER);
			if(facade != null) {
				System.out.println("name: " + facade.getClass());								
			}
			if(facade instanceof CustomerFacade) {
				CustomerFacade customerFacade = (CustomerFacade)facade;
//				customerFacade
			}			
			
			
//			CompanyFacade companyFacade = new CompanyFacade(adminFacade.getOneCompany(1));
//			companyFacade.addCoupon(new Coupon(0, 1, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
//			companyFacade.addCoupon(new Coupon(0, 1, Category.FOOD, "car", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 500, 658.5, "fooooood"));
			
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
