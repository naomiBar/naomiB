package coupons.core.facade;

import java.util.ArrayList;
import java.util.List;

import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private int companyId;

	public CompanyFacade() throws CouponSystemException {
		super();
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		this.companyId = companiesDao.isCompanyExistsRtnId(email, password);
		return this.companyId != -1;
	}

	/**
	 * adds the coupon and set the id of the parameter and return the id. 
	 * @param coupon to be added
	 * @return the generated id
	 * @throws CouponSystemException if the coupon's features are null or
	 * 			this.companyId not equals to coupon's companyId or
	 * 			companyId and title of the coupon are taken
	 */
	public int addCoupon(Coupon coupon) throws CouponSystemException {
		//check if coupon's features are not null:
		if (coupon == null || coupon.getCompanyId() == 0 || coupon.getCategory() == null || coupon.getTitle() == null
				|| coupon.getDescription() == null || coupon.getStartDate() == null || coupon.getEndDate() == null
				|| coupon.getAmount() == 0 || coupon.getPrice() == 0 || coupon.getImage() == null) {
			throw new CouponSystemException("addCoupon failed - impossible add coupon with null features");
		}
		//check if this.companyId equals to coupon's companyId:
		if(this.companyId != coupon.getCompanyId()) {
			throw new CouponSystemException("addCoupon failed - You can not add a coupon without your companyId");			
		}
		//check if coupon exist by companyId and title:
		if(couponsDao.isCouponExistsByTitleOfCompany(coupon.getCompanyId(), coupon.getTitle())) {
			throw new CouponSystemException("addCoupon failed - title already exist for this coupon id");
		}	
		return couponsDao.addCoupon(coupon);
	}

	/**
	 * update a coupon
	 * @param coupon to be updated
	 * @throws CouponSystemException if the coupon's features are null or the id and comanyId not exits
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		//check if coupon's features are not null:
		if (coupon == null || coupon.getCompanyId() == 0 || coupon.getCategory() == null || coupon.getTitle() == null
				|| coupon.getDescription() == null || coupon.getStartDate() == null || coupon.getEndDate() == null
				|| coupon.getAmount() == 0 || coupon.getPrice() == 0 || coupon.getImage() == null) {
			throw new CouponSystemException("updateCoupon failed - impossible update coupon with null features");
		}
		//check if coupon exist by id and companyId:
		if (!couponsDao.isCouponExistsByIdAndCompanyId(coupon.getId(), coupon.getCompanyId())) {
			throw new CouponSystemException("updateCoupon failed - impossible update company if id or companyId of coupon not exist");		
		}
		couponsDao.updateCoupon(coupon);				
	}

	/**
	 * delete a coupon by id
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void deleteCoupon(int couponId) throws CouponSystemException {
		//check if coupon purchase exists by couponId
		if(couponsDao.isCouponsPurchaseExistsByCouponId(couponId)) {
			System.out.println("isCouponsPurchaseExistsByCouponId");
			couponsDao.deleteCouponPurchaseByCouponId(couponId);
		}
		couponsDao.deleteCoupon(couponId);
	}

	/**
	 * return all the company's coupons in the DB.
	 * @return a list of all company's coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : couponsDao.getAllCoupons()) {
			if (coupon.getCompanyId() == companyId) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	/**
	 * return all the company's coupons from a specific category in the DB.
	 * @param category
	 * @return a list of all the company's coupons from a specific category
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCompanyCoupons()) {
			if (coupon.getCategory() == category) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	/**
	 * return all the company's coupons up to maximum price in the DB.
	 * @param maxPrice
	 * @return a list of all the company's coupons up to maximum price
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCompanyCoupons()) {
			if (coupon.getPrice() <= maxPrice) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	/**
	 * return company's details.
	 * @return the company
	 * @throws CouponSystemException
	 */
	public Company getCompanyDetails() throws CouponSystemException {
		return companiesDao.getOneCompany(companyId);
	}

}
