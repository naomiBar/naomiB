package coupons.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coupons.core.entities.Category;
import coupons.core.entities.Company;
import coupons.core.entities.Coupon;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.services.CompanyService;

@RestController
@RequestMapping("/company") //http://localhost:8080/company
public class CompanyController extends ClientController {
	
	
	@Autowired
	private CompanyService service;

	
	@PutMapping(path = "/login/{email}/{password}")
	@Override
	public boolean login(@PathVariable String email, @PathVariable String password) {
		return this.service.login(email, password);
	}
	
	@PostMapping(path = "/addCoupon")
	public void addCoupon(@RequestBody Coupon coupon) {
//		this.service.setCompanyId(1);
		try {
			this.service.addCoupon(coupon);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PutMapping(path = "/updateCoupon")
	public void updateCoupon(@RequestBody Coupon coupon) {
//		this.service.setCompanyId(8);
		try {
			this.service.updateCoupon(coupon);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());	
		}
	}
	
	@DeleteMapping(path = "/deleteCoupon/{couponId}")
	public void deleteCoupon(@PathVariable int couponId) {
//		this.service.setCompanyId(8);
		try {
			this.service.deleteCoupon(couponId);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());	
		}
	}
	
	@GetMapping(path = "/getCompanyDetails")
	public Company getCompanyDetails() {
//		this.service.setCompanyId(9);
		try {
			return this.service.getCompanyDetails();
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());	
		}
	}
	
	@GetMapping(path = "/getCompanyCoupons")
	public List<Coupon> getCompanyCoupons() {
//		this.service.setCompanyId(2);
		return this.service.getCompanyCoupons();
	}
	
	@GetMapping(path = "/getCompanyCouponsByCategory/{category}")
	public List<Coupon> getCompanyCoupons(@PathVariable Category category) {
//		this.service.setCompanyId(2);
		return this.service.getCompanyCoupons(category);
	}
	
	@GetMapping(path = "/getCompanyCouponsByMaxPrice/{maxPrice}")
	public List<Coupon> getCompanyCoupons(@PathVariable double maxPrice) {
//		this.service.setCompanyId(2);
		return this.service.getCompanyCoupons(maxPrice);
	}	
}
