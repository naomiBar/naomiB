package coupons.core.facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private int companyId;

	public CompanyFacade(Company company) throws CouponSystemException {
		super();
		if (!login(company.getEmail(), company.getPassword())) {
			throw new CouponSystemException("this company not exists");
		}
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		this.companyId = companiesDao.isCompanyExistsRtnId(email, password);
		return companiesDao.isCompanyExists(email, password);
	}

	public void addCoupon(Coupon coupon) throws CouponSystemException {
		if (coupon != null && coupon.getCompanyId() != 0 && coupon.getCategory() != null && coupon.getTitle() != null
				&& coupon.getDescription() != null && coupon.getStartDate() != null && coupon.getEndDate() != null
				&& coupon.getAmount() != 0 && coupon.getPrice() != 0 && coupon.getImage() != null
				&& !couponsDao.isCouponExistsByTitleOfCompany(coupon.getCompanyId(), coupon.getTitle())) {
			couponsDao.addCoupon(coupon);
		}
	}

	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		if (couponsDao.isCouponExistsByIdAndCompanyId(coupon.getId(), coupon.getCompanyId())) {
			if(coupon.getCategory() != null && coupon.getTitle() != null
				&& coupon.getDescription() != null && coupon.getStartDate() != null && coupon.getEndDate() != null
				&& coupon.getAmount() != 0 && coupon.getPrice() != 0 && coupon.getImage() != null) {
				couponsDao.updateCoupon(coupon);				
			}
		}
	}

	public void deleteCoupon(int couponId) throws CouponSystemException {
		couponsDao.deleteCoupon(couponId);
		couponsDao.deleteCouponById(couponId);
	}

	public List<Coupon> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : couponsDao.getAllCoupons()) {
			if (coupon.getCompanyId() == companyId) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCompanyCoupons()) {
			if (coupon.getCategory() == category) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCompanyCoupons()) {
			if (coupon.getPrice() <= maxPrice) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	public Company getCompanyDetails() throws CouponSystemException {
		return companiesDao.getOneCompany(companyId);
	}

}
