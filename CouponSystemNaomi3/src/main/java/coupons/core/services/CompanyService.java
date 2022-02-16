package coupons.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coupons.core.entities.Category;
import coupons.core.entities.Company;
import coupons.core.entities.Coupon;
import coupons.core.exceptions.CouponSystemException;

@Service
@Transactional
@Scope("prototype")
public class CompanyService extends ClientService {

	private int companyId;

	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public boolean login(String email, String password) {
		Optional<Company> opt = companyRepository.findCompanyByEmailAndPassword(email, password);
		if (opt.isPresent()) {
			this.companyId = opt.get().getId();
			return true;
		}
		return false;
	}

	/**
	 * adds the coupon.
	 * @param coupon to be added
	 * @throws CouponSystemException if the coupon's features are null,
	 *              or if coupon's dates are not correct,
	 *              or companyId and title of the coupon are taken
	 */
	public void addCoupon(Coupon coupon) throws CouponSystemException {
		// check if coupon's features are not null:
		if (coupon.getCategory() == null || coupon.getTitle() == null || coupon.getDescription() == null
				|| coupon.getStartDate() == null || coupon.getEndDate() == null || coupon.getAmount() == 0
				|| coupon.getPrice() == 0 || coupon.getImage() == null) {
			throw new CouponSystemException("addCoupon failed - impossible add coupon with null features");
		}
		
		// check if the dates of the coupon are correct:
		if(LocalDate.now().isAfter(coupon.getStartDate()) || LocalDate.now().isAfter(coupon.getEndDate())
				|| coupon.getEndDate().isBefore(coupon.getStartDate())) {
			throw new CouponSystemException("addCoupon failed - The dates of the coupon not correct");
		}

		// check if coupon exist by companyId and title:
		if (!(this.couponRepository.existsByTitleAndCompanyId(coupon.getTitle(), this.companyId))) {
			Company company = this.getCompanyDetails();
			company.addCoupon(coupon);
		} else {
			throw new CouponSystemException("addCoupon failed - title already exists for this company");
		}
	}

	/**
	 * update a coupon
	 * @param coupon to be updated
	 * @throws CouponSystemException if the coupon's features are null or the coupon not exists by id and companyId
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		// check if coupon's features are not null:
		if (coupon.getCategory() == null || coupon.getTitle() == null || coupon.getDescription() == null
				|| coupon.getStartDate() == null || coupon.getEndDate() == null || coupon.getAmount() == 0
				|| coupon.getPrice() == 0 || coupon.getImage() == null) {
			throw new CouponSystemException("updateCoupon failed - impossible update coupon with null features");
		}
		// check if coupon exists by id and companyId:
		if(this.couponRepository.existsByIdAndCompanyId(coupon.getId(), this.companyId)) {
			coupon.setCompany(getCompanyDetails());
			this.couponRepository.save(coupon);
		} else {
			throw new CouponSystemException("updateCoupon failed - coupon id " + coupon.getId() + " NOT exist in this company ");
		}
		
		
	}

	/**
	 * delete a coupon by id
	 * @param couponId
	 * @throws CouponSystemException if the coupon not exists by id and companyId
	 */
	public void deleteCoupon(int couponId) throws CouponSystemException {
		// check if coupon exists by id and companyId:
		if (this.couponRepository.existsByIdAndCompanyId(couponId, this.companyId)) {
			this.couponRepository.deleteById(couponId);
		} else {
			throw new CouponSystemException("deleteCoupon failed - coupon id " + couponId + " NOT exist in this company ");
		}
	}

	/**
	 * return company's details.
	 * @return the company
	 * @throws CouponSystemException if company's id not found
	 */
	public Company getCompanyDetails() throws CouponSystemException {
		Optional<Company> opt = this.companyRepository.findById(this.companyId);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new CouponSystemException("getCompanyDetails failed - company id " + this.companyId + " NOT found");
	}

	/**
	 * return all the company's coupons in the DB.
	 * @return a list of all company's coupons
	 */
	public List<Coupon> getCompanyCoupons() {
		return this.couponRepository.findCouponsByCompanyId(companyId);
	}

	/**
	 * return all the company's coupons from a specific category in the DB.
	 * @param category
	 * @return a list of all the company's coupons from a specific category
	 */
	public List<Coupon> getCompanyCoupons(Category category) {
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
	 */
	public List<Coupon> getCompanyCoupons(double maxPrice) {
		List<Coupon> coupons = new ArrayList<>();
		for (Coupon coupon : getCompanyCoupons()) {
			if (coupon.getPrice() <= maxPrice) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
}
