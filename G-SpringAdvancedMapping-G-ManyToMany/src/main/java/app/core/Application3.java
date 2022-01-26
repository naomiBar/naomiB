package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.repos.CustomerRepo;

@SpringBootApplication
public class Application3 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application3.class, args);

		CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
		
		Coupon coupon1 = new Coupon(0, "food", null, null);
		Coupon coupon2 = new Coupon(0, "travel", null, null);
		Coupon coupon3 = new Coupon(0, "movie", null, null);
		
		Customer customer = new Customer(0, "Naomi", "naomi@mail", null);
		customer.addCoupon(coupon1);
		customer.addCoupon(coupon2);
		customer.addCoupon(coupon3);	
		
		customerRepo.save(customer);
		
	}
}
