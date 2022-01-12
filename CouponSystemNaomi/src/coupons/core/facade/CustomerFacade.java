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
		if(customersDao.isPurchaseCouponExists(customerId, coupon.getId())) {
			throw new CouponSystemException("purchaseCoupon failed - isPurchaseCouponExists");
		}
		if (coupon.getAmount() == 0) {
			throw new CouponSystemException("purchaseCoupon failed - There are no coupons left to purchase");			
		}
		if(coupon.getEndDate().isBefore(LocalDate.now())) {
			throw new CouponSystemException("purchaseCoupon failed - The coupon has expired");			
		}
		if(!couponsDao.isCouponExistsByCouponId(coupon.getId())) {
			throw new CouponSystemException("purchaseCoupon failed - coupon " + coupon.getId() + " not exists");						
		}
		couponsDao.addCouponPurchase(customerId, coupon.getId());
		coupon.setAmount(coupon.getAmount() - 1);
		couponsDao.updateAmountCoupon(coupon.getAmount(), coupon.getId());
		System.out.println("purchaseCoupon - id: " + coupon.getId());				
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
