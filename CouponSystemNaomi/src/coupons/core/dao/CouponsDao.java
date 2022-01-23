package coupons.core.dao;

import java.util.List;

import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public interface CouponsDao {
	
	/**
	 * adds the coupon and set the id of the parameter and return the id.
	 * @param coupon to be added
	 * @return the generated id
	 * @throws CouponSystemException
	 */
	public int addCoupon(Coupon coupon) throws CouponSystemException;
	
	/**
	 * update a coupon
	 * @param coupon to be updated
	 * @throws CouponSystemException if coupon's id not found
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException;
	
	/**
	 * delete a coupon by id.
	 * @param couponId
	 * @throws CouponSystemException if coupon's id not found
	 */
	public void deleteCoupon(int couponId) throws CouponSystemException;
	
	/**
	 * return the coupon by id.
	 * @param couponId
	 * @return the coupon
	 * @throws CouponSystemException if coupon's id not found
	 */
	public Coupon getOneCoupon(int couponId) throws CouponSystemException;
	
	/**
	 * return all the coupons in the DB.
	 * @return a list of all coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getAllCoupons() throws CouponSystemException;
	
	/**
	 * adds a couponPurchase with customerId and couponId.
	 * @param customerId
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void addCouponPurchase(int customerId, int couponId) throws CouponSystemException;
	
	/**
	 * delete a couponPurchase with customerId and couponId.
	 * @param customerId
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException;
	
	/**
	 * check if couponsPurchase exist by customerId and couponId,
	 * its for purchase a coupon.
	 * @param customerId
	 * @param couponId
	 * @return true if couponsPurchase exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponPurchaseExists(int customerId, int couponId) throws CouponSystemException;
	
	/**
	 * check if coupon exist by companyId and title,
	 * its for add a coupon.
	 * @param companyId
	 * @param title
	 * @return true if coupon exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponExistsByTitleOfCompany(int companyId, String title) throws CouponSystemException;
	
	/**
	 * check if coupon exist by id and companyId,
	 * its for update a coupon.
	 * @param couponId
	 * @param companyId
	 * @return true if coupon exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponExistsByIdAndCompanyId(int couponId, int companyId) throws CouponSystemException;
	
	/**
	 * check if couponsPurchase exist by couponId,
	 * its for delete the coupon.
	 * @param couponId
	 * @return true if couponsPurchase exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponsPurchaseExistsByCouponId(int couponId) throws CouponSystemException;
	
	/**
	 * delete couponsPurchase by couponId,
	 * before delete the coupon.
	 * @param couponId
	 * @throws CouponSystemException if coupon's id not found
	 */
	public void deleteCouponPurchaseByCouponId(int couponId) throws CouponSystemException;
	
	/**
	 * check if coupon exist by couponId,
	 * its for purchase the coupon.
	 * @param couponId
	 * @return true if coupons exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponExistsByCouponId(int couponId) throws CouponSystemException;
	
	/**
	 * reducing the amount of the coupon in stock by 1
	 * @param amount
	 * @param couponId
	 * @throws CouponSystemException if coupon's id not found
	 */
	public void updateAmountCoupon(int amount, int couponId) throws CouponSystemException;
}
