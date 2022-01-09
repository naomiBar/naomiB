package coupons.core.dao;

import java.util.List;

import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public interface CouponsDao {
	
	public int addCoupon(Coupon coupon) throws CouponSystemException;
	public void updateCoupon(Coupon coupon) throws CouponSystemException;
	public void deleteCoupon(int couponId) throws CouponSystemException;
	public void deleteCouponsOfCompany(int companyId) throws CouponSystemException;
	public List<Coupon> getAllCoupons() throws CouponSystemException;
	public Coupon getOneCoupon(int couponId) throws CouponSystemException;
	public void addCouponPurchase(int customerId, int couponId) throws CouponSystemException;
	public void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException;
	public void deleteCouponPurchase(int couponId) throws CouponSystemException;
}