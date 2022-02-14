package coupons.core.tests;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coupons.core.entities.Company;
import coupons.core.entities.Customer;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;
import coupons.core.services.AdminService;

@Component
public class AdminTest {
	
	@Autowired
	private LoginManager loginManager;
	
	@PostConstruct
	public void test() throws CouponSystemException {
		System.out.println("===================== ADMIN ============================");
		AdminService adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
		System.out.println("adminService: " + adminService);
		
		if(adminService instanceof AdminService) {
			//for Company:
			int id = adminService.addCompany(new Company(0, "castro", "castro@gmail.com", "1234", null));
			id = adminService.addCompany(new Company(0, "am:pm", "am:pm@gmail.com", "1234", null));
			id = adminService.addCompany(new Company(0, "McDonald's", "McDonald's@gmail.com", "1234", null));
			id = adminService.addCompany(new Company(0, "daka90", "daka90@gmail.com", "1234", null));
			
			id = adminService.addCompany(new Company(0, "adidas", "adidas@gmail.com", "1234", null));
			//will be failed because impossible to update company's name:
//			adminService.updateCompany(new Company(id, "adida", "adidas@gmail.com", "0000", null));
			adminService.updateCompany(new Company(id, "adidas", "adidas@gmail.com", "0000", null));
			System.out.println("company: " + adminService.getOneCompany(id));
			adminService.deleteCompany(id);
			
			System.out.println("allCompanies: " + adminService.getAllCompanies());
			
			System.out.println("=================================================");
			
			//for Customer:
			id = adminService.addCustomer(new Customer(0, "roni", "cohen", "roni@gmail.com", "0000", null));
			id = adminService.addCustomer(new Customer(0, "dan", "levi", "dan@gmail.com", "0000", null));
			id = adminService.addCustomer(new Customer(0, "gali", "dahan", "gali@gmail.com", "0000", null));
			
			//will be failed because impossible to add customer if the email is taken:
//			id = adminService.addCustomer(new Customer(0, "naomigg", "bar", "roni@gmail.com", "0000", null));
			id = adminService.addCustomer(new Customer(0, "naomigg", "bar", "naomi@gmail.com", "0000", null));
			adminService.updateCustomer(new Customer(id, "naomi", "bar", "naomi@gmail.com", "0000", null));
			System.out.println("customer: " + adminService.getOneCustomer(id));
			adminService.deleteCustomer(id);
			
			System.out.println("allCustomers: " + adminService.getAllCustomers());
		
		}
	}
}
