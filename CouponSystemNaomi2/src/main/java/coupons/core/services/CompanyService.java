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
	 *              or if coupon's expiration date has already been reached,
	 *              or companyId and title of the coupon are taken
	 */
	public void addCoupon(Coupon coupon) throws CouponSystemException {
		// check if coupon's features are not null:
		if (coupon.getCategory() == null || coupon.getTitle() == null || coupon.getDescription() == null
				|| coupon.getStartDate() == null || coupon.getEndDate() == null || coupon.getAmount() == 0
				|| coupon.getPrice() == 0 || coupon.getImage() == null) {
			throw new CouponSystemException("addCoupon failed - impossible add coupon with null features");
		}
		
		// check if coupon's expiration date has already been reached:
		if (LocalDate.now().isBefore(coupon.getEndDate())) {

			// check if coupon exist by companyId and title:
			if (!(this.couponRepository.existsByTitleAndCompanyId(coupon.getTitle(), this.companyId))) {
				Company company = this.getCompanyDetails();
				company.addCoupon(coupon);
			} else {
				throw new CouponSystemException("addCoupon failed - title already exists for this coupon id");
			}
			
		} else {
			throw new CouponSystemException("addCoupon failed - The coupon has expired");
		} 
	}

	
	/**
	 * update a coupon
	 * @param coupon to be updated
	 * @throws CouponSystemException if the coupon's features are null or the id not exists
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		//check if coupon's features are not null:
		if (coupon.getCategory() == null || coupon.getTitle() == null || coupon.getDescription() == null
				|| coupon.getStartDate() == null || coupon.getEndDate() == null
				|| coupon.getAmount() == 0 || coupon.getPrice() == 0 || coupon.getImage() == null) {
			throw new CouponSystemException("updateCoupon failed - impossible update coupon with null features");
		}
		//check if coupon exists by id:
		if(this.couponRepository.existsById(coupon.getId())) {
			coupon.setCompany(getCompanyDetails());
			this.couponRepository.save(coupon);
		}else {
			throw new CouponSystemException("updateCoupon failed - coupon id " + coupon.getId() + " NOT found");
		}				
	}

	/**
	 * delete a coupon by id
	 * @param couponId
	 * @throws CouponSystemException if coupon's id not found
	 */
	public void deleteCoupon(int couponId) throws CouponSystemException {
		//check if coupon exists by id:
		if(this.couponRepository.existsById(couponId)) {
			this.couponRepository.deleteById(couponId);
		}else {
			throw new CouponSystemException("deleteCoupon failed - coupon id " + couponId + " NOT found");
		}		
	}

	/**
	 * return company's details.
	 * @return the company
	 * @throws CouponSystemException if company's id not found 
	 */
	public Company getCompanyDetails() throws CouponSystemException {
		Optional<Company> opt = this.companyRepository.findById(this.companyId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CouponSystemException("getCompanyDetails failed - company id " + this.companyId + " NOT found");
	}
	
	/**
	 * return all the company's coupons in the DB.
	 * @return a list of all company's coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> coupons = getCompanyDetails().getCoupons();
		System.out.println("~~~~~~ " + coupons);
		return coupons;
		
//		return getCompanyDetails().getCoupons();
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
}
