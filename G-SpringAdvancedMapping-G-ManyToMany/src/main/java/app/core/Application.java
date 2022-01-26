package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.repos.CouponRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
		
		Customer customer1 = new Customer(0, "Ron", "ron@mail", null);
		Customer customer2 = new Customer(0, "Dor", "dor@mail", null);
		Customer customer3 = new Customer(0, "Maya", "maya@mail", null);
		
		Coupon coupon = new Coupon(0, "bbb", null, null);
		coupon.addCustomer(customer1);
		coupon.addCustomer(customer2);
		coupon.addCustomer(customer3);
		
		couponRepo.save(coupon);
	}
}
