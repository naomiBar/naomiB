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

	public CouponExpirationDailyJob() throws CouponSystemException {
		this.couponsDao = new CouponsDBDao();
	}

	@Override
	public void run() {
		try {
			while (!quit) {
				for (Coupon coupon : couponsDao.getAllCoupons()) {
					if (coupon.getEndDate().isAfter(LocalDate.now())) {
						
						if (couponsDao.isCouponPurchaseExistsByCouponId(coupon.getId())) {
							System.out.println("isCouponPurchaseExistsByCouponId");
							couponsDao.deleteCouponPurchase(coupon.getId());
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

	public void stop() {
		this.quit = true;
		System.out.println(">> stop");
	}

}
