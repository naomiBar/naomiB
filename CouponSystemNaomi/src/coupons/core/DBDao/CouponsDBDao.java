package coupons.core.DBDao;

import java.util.ArrayList;

import coupons.core.beans.Coupon;
import coupons.core.dao.CouponsDao;
import coupons.core.exceptions.CouponSystemException;

public class CouponsDBDao implements CouponsDao{
	
	private ConnectionPool connectionPool;
	
	public CouponsDBDao() throws CouponSystemException {
		this.connectionPool = ConnectionPool.getInstance();	}

	@Override
	public void addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCoupon(int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getOneCoupon(int couponId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCouponPurchase(int customerId, int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCouponPurchase(int customerId, int couponId) {
		// TODO Auto-generated method stub
		
	}

}
