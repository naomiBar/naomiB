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
		return this.customerId != -1;
	}

	/**
	 * purchase a coupon and reducing the amount in stock by 1
	 * @param coupon
	 * @throws CouponSystemException if couponPurcahse exist already,
	 * 			 or if the coupon amount is 0,
	 * 			 or if coupon's expiration date has already been reached,
	 * 			 or if coupon not exist by id.
	 */
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		//check if couponPurcahse exist already by id and customerId:
		if(couponsDao.isCouponPurchaseExists(customerId, coupon.getId())) {
			throw new CouponSystemException("purchaseCoupon failed - isPurchaseCouponExists");
		}
		//check if the coupon amount is 0:
		if (coupon.getAmount() == 0) {
			throw new CouponSystemException("purchaseCoupon failed - There are no coupons left to purchase");			
		}
		//check if coupon's expiration date has already been reached:
		if(coupon.getEndDate().isBefore(LocalDate.now())) {
			throw new CouponSystemException("purchaseCoupon failed - The coupon has expired");			
		}
		//check if coupon exist by id:
		if(!couponsDao.isCouponExistsByCouponId(coupon.getId())) {
			throw new CouponSystemException("purchaseCoupon failed - coupon " + coupon.getId() + " not exists");						
		}
		couponsDao.addCouponPurchase(customerId, coupon.getId());
		coupon.setAmount(coupon.getAmount() - 1);
		couponsDao.updateAmountCoupon(coupon.getAmount(), coupon.getId());
		System.out.println("purchaseCoupon - id: " + coupon.getId());				
	}

	/**
	 * return all the customer's coupons in the DB.
	 * @return a list of all customer's coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : couponsDao.getAllCoupons()) {
			if(couponsDao.isCouponPurchaseExists(customerId, coupon.getId())) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	/**
	 * return all the customer's coupons from a specific category in the DB.
	 * @param category
	 * @return a list of all the customer's coupons from a specific category
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCustomerCoupons()) {
			if(coupon.getCategory() == category ) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	/**
	 * return all the customer's coupons up to maximum price in the DB.
	 * @param maxPrice
	 * @return a list of all the customer's coupons up to maximum price
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCustomerCoupons	()) {
			if(coupon.getPrice() <= maxPrice ) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	/**
	 * return customer's details.
	 * @return the customer
	 * @throws CouponSystemException
	 */
	public Customer getCustomerDetails() throws CouponSystemException {
		return customersDao.getOneCustomer(customerId);
	}
}
