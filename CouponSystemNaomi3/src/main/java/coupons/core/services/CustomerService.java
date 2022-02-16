package coupons.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coupons.core.entities.Category;
import coupons.core.entities.Coupon;
import coupons.core.entities.Customer;
import coupons.core.exceptions.CouponSystemException;

@Service
@Transactional
@Scope("prototype")
public class CustomerService extends ClientService{

	private int customerId;
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public boolean login(String email, String password) {
		Optional<Customer> opt = this.customerRepository.findCustomerByEmailAndPassword(email, password);
		if(opt.isPresent()) {
			this.customerId = opt.get().getId();
			return true;
		}
		return false;
	}
	
	/**
	 * return customer's details.
	 * @return the customer
	 * @throws CouponSystemException if customer's id not found
	 */
	public Customer getCustomerDetails() throws CouponSystemException {
		Optional<Customer> opt = this.customerRepository.findById(this.customerId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CouponSystemException("getCustomerDetails failed - customer id " + this.customerId + " NOT found");
	}
	
	
	/**
	 * purchase a coupon and reducing the amount in stock by 1
	 * @param couponId
	 * @throws CouponSystemException if coupon not exist by id,
	 * 			 or if couponPurcahse exist already,
	 * 			 or if the coupon amount is 0.
	 */
	public void purchaseCoupon(int couponId) throws CouponSystemException {
		//check if coupon exist by id:
		Optional<Coupon> opt = this.couponRepository.findById(couponId);
		if(opt.isPresent()) {
			Coupon coupon = opt.get();
			
			//check if couponPurcahse exist already by id and customerId:
			if(getCustomerDetails().getCoupons().contains(coupon)) {
				throw new CouponSystemException("purchaseCoupon failed - isPurchaseCouponExists");
			}
			
			//check if the coupon amount is 0:
			if (coupon.getAmount() == 0) {
				throw new CouponSystemException("purchaseCoupon failed - There are no coupons left to purchase");			
			}
			
			getCustomerDetails().addCoupon(coupon);
			coupon.setAmount(coupon.getAmount() - 1);
		}else {
			throw new CouponSystemException("purchaseCoupon failed - coupon " + couponId + " NOT found");
		}
	}
	
	/**
	 * return all the customer's coupons in the DB.
	 * @return a list of all customer's coupons
	 */
	public List<Coupon> getCustomerCoupons() {
		return this.couponRepository.findCouponsByCustomersId(customerId);
	}
	
	
	/**
	 * return all the customer's coupons from a specific category in the DB.
	 * @param category
	 * @return a list of all the customer's coupons from a specific category
	 */
	public List<Coupon> getCustomerCoupons(Category category) {
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
	 */
	public List<Coupon> getCustomerCoupons(double maxPrice) {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCustomerCoupons	()) {
			if(coupon.getPrice() <= maxPrice ) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
}
