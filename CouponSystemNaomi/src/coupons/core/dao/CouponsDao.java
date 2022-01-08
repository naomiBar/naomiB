package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Coupon;

public interface CouponsDao {
	
	public void addCoupon(Coupon coupon);
	public void updateCoupon(Coupon coupon);
	public void deleteCoupon(int couponId);
	public ArrayList<Coupon> getAllCoupons();
	public Coupon getOneCoupon(int couponId);
	public void addCouponPurchase(int customerId, int couponId);
	public void deleteCouponPurchase(int customerId, int couponId);
}
