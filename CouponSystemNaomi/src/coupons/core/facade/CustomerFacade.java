package coupons.core.facade;

import java.util.List;

import coupons.core.beans.Category;
import coupons.core.beans.Coupon;

public class CustomerFacade extends ClientFacade {

	private int customerId;
	
	public CustomerFacade() {
	}
	
	@Override
	public boolean login(String email, String password) {
		return false;
	}
	
	public void purchaseCoupon(Coupon coupon) {
		
	}
	
	public List<Coupon> getCustomerCoupons(){
		return null;
	}
	
	public List<Coupon> getCustomerCoupons(Category category){
		return null;
	}
	
	public List<Coupon> getCustomerCoupons(double maxPrice){
		return null;
	}

	public List<Coupon> getCustomerDetails(){
		return null;
	}
}
