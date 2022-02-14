package coupons.core.tests;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coupons.core.entities.Category;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;
import coupons.core.services.CustomerService;

@Component
public class CustomerTest {
	
	@Autowired
	private LoginManager loginManager;
	
	@PostConstruct
	public void test() throws CouponSystemException {
		System.out.println("===================== CUSTOMER ============================");
		CustomerService customerService = (CustomerService) loginManager.login("roni@gmail.com", "0000", ClientType.CUSTOMER);
		System.out.println("customerService: " + customerService);
		
		if(customerService instanceof CustomerService) {
			
			System.out.println(">>customer:" + customerService.getCustomerDetails());
			
			customerService.purchaseCoupon(1);
			customerService.purchaseCoupon(2);
//			customerService.purchaseCoupon(8); //will be fail because the coupon not exists
			
			
			System.out.println(">>>getCustomerCoupons: " + customerService.getCustomerCoupons());
			System.out.println(">>>getCustomerCoupons by category: " + customerService.getCustomerCoupons(Category.TRAVEL));
			System.out.println(">>>getCustomerCoupons by maxPrice: " + customerService.getCustomerCoupons(1000));
		}
		
		//another customer:
		customerService = (CustomerService) loginManager.login("gali@gmail.com", "0000", ClientType.CUSTOMER);
		System.out.println("customerService: " + customerService);
		
		if(customerService instanceof CustomerService) {
			
			System.out.println(">>customer:" + customerService.getCustomerDetails());
			
			customerService.purchaseCoupon(2);
//			customerService.purchaseCoupon(1);  //will be fail because there are no coupons left to purchase
		}
	}
}
