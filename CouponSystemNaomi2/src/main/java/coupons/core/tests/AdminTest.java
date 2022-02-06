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
		AdminService adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
		System.out.println("adminService: " + adminService);
		
		if(adminService instanceof AdminService) {
			//for Company:
			int id = adminService.addCompany(new Company(0, "nutella", "nutella@gmail.com", "1234", null));
			
			id = adminService.addCompany(new Company(0, "cola", "co@gmail.com", "1234", null));
			
			adminService.updateCompany(new Company(id, "cola", "cola@gmail.com", "0000", null));
			System.out.println("company: " + adminService.getOneCompany(id));
			adminService.deleteCompany(id);
			
			System.out.println("allCompanies: " + adminService.getAllCompanies());
			
			System.out.println("=================================================");
			
			//for Customer:
			id = adminService.addCustomer(new Customer(0, "naomi", "bar", "naomi@gmail.com", "0000", null));
			
			id = adminService.addCustomer(new Customer(0, "odel", "levi", "odel@gmail.com", "0000", null));
			
			adminService.updateCustomer(new Customer(id, "odel", "bar", "odel@gmail.com", "0000", null));
			System.out.println("customer: " + adminService.getOneCustomer(id));
//			adminService.deleteCustomer(id);
			
			System.out.println("allCustomers: " + adminService.getAllCustomers());
		
		}
	}
}
