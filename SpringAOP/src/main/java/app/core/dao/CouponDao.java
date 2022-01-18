package app.core.dao;

import org.springframework.stereotype.Component;

@Component
public class CouponDao {

	//Business methods to be intercepted as joinpoints
	public void addCoupon(int id) {
		System.out.println("coupon " + id + " added");
	}
	
	public void doWork() {
		System.out.println("doing some work at CouponDao");
	}
}
