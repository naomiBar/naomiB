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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coupons.core.entities.Category;
import coupons.core.entities.Company;
import coupons.core.entities.Coupon;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.jws.util.JwtUtil;
import coupons.core.services.CompanyService;

@RestController
@RequestMapping("/api/COMPANY")
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(path = "/addCoupon")
	public void addCoupon(@RequestBody Coupon coupon, @RequestHeader String token) {
		try {
			this.service.addCoupon(coupon, this.jwtUtil.extractClient(token).getClentId());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping(path = "/updateCoupon")
	public void updateCoupon(@RequestBody Coupon coupon, @RequestHeader String token) {
		try {
			this.service.updateCoupon(coupon, this.jwtUtil.extractClient(token).getClentId());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@DeleteMapping(path = "/deleteCoupon/{couponId}")
	public void deleteCoupon(@PathVariable int couponId, @RequestHeader String token) {
		try {
			this.service.deleteCoupon(couponId, this.jwtUtil.extractClient(token).getClentId());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping(path = "/getOneCoupon/{couponId}")
	public Coupon getOneCoupon(@PathVariable int couponId, @RequestHeader String token) {
		try {
			return this.service.getOneCoupon(couponId, this.jwtUtil.extractClient(token).getClentId());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(path = "/getCompanyDetails")
	public Company getCompanyDetails(@RequestHeader String token) {
		try {
			return this.service.getCompanyDetails(this.jwtUtil.extractClient(token).getClentId());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(path = "/getCompanyCoupons")
	public List<Coupon> getCompanyCoupons(@RequestHeader String token) throws CouponSystemException {
		return this.service.getCompanyCoupons(this.jwtUtil.extractClient(token).getClentId());
	}

	@GetMapping(path = "/getCompanyCouponsByCategory/{category}")
	public List<Coupon> getCompanyCoupons(@PathVariable Category category, @RequestHeader String token) throws CouponSystemException {
		return this.service.getCompanyCoupons(category, this.jwtUtil.extractClient(token).getClentId());
	}

	@GetMapping(path = "/getCompanyCouponsByMaxPrice/{maxPrice}")
	public List<Coupon> getCompanyCoupons(@PathVariable double maxPrice, @RequestHeader String token) throws CouponSystemException {
		return this.service.getCompanyCoupons(maxPrice, this.jwtUtil.extractClient(token).getClentId());
	}
}
