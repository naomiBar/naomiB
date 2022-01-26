package app.core;

import java.util.NoSuchElementException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.repos.CouponRepo;
import app.core.repos.CustomerRepo;

@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application2.class, args);
		
		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
		CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
		
		//get the coupon or throw an exception if not found:
		try {
			int couponId = 1;
			Coupon coupon = couponRepo.findById(couponId).orElseThrow();
			System.out.println(coupon);
//			System.out.println(coupon.getCustomers()); //error because is lazy
			System.out.println(customerRepo.findCustomersByCouponsId(couponId));
			
		} catch (NoSuchElementException e) {
			System.out.println("NOT FOUND: " + e.getMessage());
		}
	}
}
