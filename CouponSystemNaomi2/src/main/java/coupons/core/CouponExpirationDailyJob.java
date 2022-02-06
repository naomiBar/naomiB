package coupons.core;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import coupons.core.entities.Coupon;
import coupons.core.repositories.CouponRepository;

public class CouponExpirationDailyJob implements Runnable {

	@Autowired
	private CouponRepository couponRepository;
	private boolean quit;
	private Thread thread = new Thread(this, "daily_job");


	public void startDailyJob() {
		this.thread.start();
	}
	
	@Override
	public void run() {
		try {
			while (!quit) {
				for (Coupon coupon : couponRepository.findAll()) {
					if (LocalDate.now().isAfter(coupon.getEndDate())) {
						
						couponRepository.deleteById(coupon.getId());
					}
				}
				TimeUnit.DAYS.sleep(1);
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException: " + e.getMessage());
		} 
	}


	public void stopDailyJob() {
		this.quit = true;
		this.thread.interrupt();
	}
	

}
