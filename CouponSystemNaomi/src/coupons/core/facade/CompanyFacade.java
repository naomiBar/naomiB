package coupons.core.facade;

import java.util.ArrayList;
import java.util.List;

import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public class CompanyFacade extends ClientFacade {
	
	private int companyId;
	
	public CompanyFacade() {
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		this.companyId = companiesDao.isCompanyExistsRtnId(email, password);
		return companiesDao.isCompanyExists(email, password);
	}
	
	public void addCoupon(Coupon coupon) throws CouponSystemException {
		if(!couponsDao.isCouponExistsByTitleOfCompany(coupon.getCompanyId(), coupon.getTitle())) {
			couponsDao.addCoupon(coupon);
		}
	}
	
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		if(couponsDao.isCouponExistsByIdAndCompanyId(coupon.getId(), coupon.getCompanyId())) {
			couponsDao.updateCoupon(coupon);
		}
	}
	
	public void deleteCoupon(int couponId) throws CouponSystemException {
		couponsDao.deleteCoupon(couponId);
		couponsDao.deleteCouponById(couponId);
	}
	
	public List<Coupon> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : couponsDao.getAllCoupons()) {
			if(coupon.getCompanyId() == companyId) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
	
	public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCompanyCoupons()) {
			if(coupon.getCategory() == category ) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
	
	public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCompanyCoupons()) {
			if(coupon.getPrice() <= maxPrice ) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
	
	public Company getCompanyDetails() throws CouponSystemException {
		return companiesDao.getOneCompany(companyId);
	}

}
