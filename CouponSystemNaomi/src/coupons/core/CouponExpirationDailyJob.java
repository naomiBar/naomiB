package coupons.core;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import coupons.core.DBDao.CouponsDBDao;
import coupons.core.beans.Coupon;
import coupons.core.dao.CouponsDao;
import coupons.core.exceptions.CouponSystemException;

public class CouponExpirationDailyJob implements Runnable {

	private CouponsDao couponsDao;
	private boolean quit;
	private Thread thread;

	public CouponExpirationDailyJob() throws CouponSystemException {
		this.couponsDao = new CouponsDBDao();
		this.thread = new Thread(this, "daily_job");
	}

	public void startDailyJob() {
		this.thread.start();
	}
	
	@Override
	public void run() {
		try {
			while (!quit) {
				for (Coupon coupon : couponsDao.getAllCoupons()) {
					if (LocalDate.now().isAfter(coupon.getEndDate())) {
						
						if (couponsDao.isCouponsPurchaseExistsByCouponId(coupon.getId())) {
							System.out.println("isCouponPurchaseExistsByCouponId");
							couponsDao.deleteCouponPurchaseByCouponId(coupon.getId());
						}
						couponsDao.deleteCoupon(coupon.getId());
					}
				}
				TimeUnit.DAYS.sleep(1);
			}
		} catch (CouponSystemException | InterruptedException e) {
			System.out.println(e.getMessage());
		} 
	}


	public void stopDailyJob() {
		this.quit = true;
		this.thread.interrupt();
	}
	

}
