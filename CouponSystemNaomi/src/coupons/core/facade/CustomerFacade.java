package coupons.core.facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import coupons.core.beans.Category;
import coupons.core.beans.Coupon;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private int customerId;

	
	public CustomerFacade() throws CouponSystemException {
		super();
	}


	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		this.customerId = customersDao.isCustomerExistsRtnId(email, password);
		return customersDao.isCustomerExists(email, password);
	}

	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		boolean isPurchaseCouponExists = customersDao.isPurchaseCouponExists(customerId, coupon.getId());

		if (!isPurchaseCouponExists && coupon.getAmount() > 0 && coupon.getEndDate().isAfter(LocalDate.now())) {
			couponsDao.addCouponPurchase(customerId, coupon.getId());
			coupon.setAmount(coupon.getAmount() - 1);
		}
	}

	public List<Coupon> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : couponsDao.getAllCoupons()) {
			if(customersDao.isPurchaseCouponExists(customerId, coupon.getId())) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	public List<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCustomerCoupons()) {
			if(coupon.getCategory() == category ) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	public List<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCustomerCoupons	()) {
			if(coupon.getPrice() <= maxPrice ) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	public Customer getCustomerDetails() throws CouponSystemException {
		return customersDao.getOneCustomer(customerId);
	}
}
