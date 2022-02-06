package coupons.core.tests;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coupons.core.entities.Category;
import coupons.core.entities.Company;
import coupons.core.entities.Coupon;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;
import coupons.core.services.CompanyService;

@Component
public class CompanyTest {
	
	@Autowired
	private LoginManager loginManager;
	
	@PostConstruct
	public void test() throws CouponSystemException {
		CompanyService companyService = (CompanyService) loginManager.login("nutella@gmail.com", "1234", ClientType.COMPANY);
		System.out.println("companyService: " + companyService);
		
		if(companyService instanceof CompanyService) {
			
			Company company = companyService.getCompanyDetails();
			System.out.println(">>company:" + company);
			
			companyService.addCoupon(new Coupon(0, Category.TRAVEL, "vaction to Eilat", "a weekend at the Dan Hotel includes a flight for NIS 1,000", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 8, 1), 500, 1000, "vactionnnn", null, null));
			companyService.updateCoupon(new Coupon(1, Category.TRAVEL, "vaction to Eilat", "a weekend at the Dan Hotel includes a flight for NIS 1,000", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 8, 1), 1, 1000, "vactionnnn", null, null));
//			companyService.addCoupon(new Coupon(0, Category.FOOD, "food for life", "good food for good life", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 20), 500, 658.5, "fooooood", null, null)); //will be fail because the end date

			
			System.out.println("getCompanyCoupons: " + companyService.getCompanyCoupons());
			System.out.println("getCompanyCoupons by category: " + companyService.getCompanyCoupons(Category.FOOD));
			System.out.println("getCompanyCoupons by maxPrice: " + companyService.getCompanyCoupons(1000));
			
//			companyService.deleteCoupon(1);
		}
	}
}
