package coupons.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coupons.core.entities.Category;
import coupons.core.entities.Coupon;
import coupons.core.entities.Customer;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.jws.util.JwtUtil;
import coupons.core.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/CUSTOMER") 
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private JwtUtil jwtUtil;

	
	@GetMapping(path = "/getCustomerDetails")
	public Customer getCustomerDetails(@RequestHeader String token) {
		try {
			return this.service.getCustomerDetails(this.jwtUtil.extractClient(token).getClentId());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());	
		}
	}
	
	@PostMapping(path = "/purchaseCoupon/{couponId}")
	public void purchaseCoupon(@PathVariable int couponId, @RequestHeader String token) {
		System.out.println(">>>>>>>>>>couponId" + couponId);
		try {
			this.service.purchaseCoupon(couponId, this.jwtUtil.extractClient(token).getClentId());
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());	
		}
	}
	
	@GetMapping(path = "/getAllCoupons")
	public List<Coupon> getAllCoupons(@RequestHeader String token) throws CouponSystemException {
		return this.service.getAllCoupons();
	}
	
	@GetMapping(path = "/getCustomerCoupons")
	public List<Coupon> getCustomerCoupons(@RequestHeader String token) throws CouponSystemException {
		return this.service.getCustomerCoupons(this.jwtUtil.extractClient(token).getClentId());
	}
	
	@GetMapping(path = "/getCustomerCouponsByCategory/{category}")
	public List<Coupon> getCustomerCoupons(@PathVariable Category category, @RequestHeader String token) throws CouponSystemException {
		return this.service.getCustomerCoupons(category, this.jwtUtil.extractClient(token).getClentId());
	}
	
	@GetMapping(path = "/getCustomerCouponsByMaxPrice/{maxPrice}")
	public List<Coupon> getCustomerCoupons(@PathVariable double maxPrice, @RequestHeader String token) throws CouponSystemException {
		return this.service.getCustomerCoupons(maxPrice, this.jwtUtil.extractClient(token).getClentId());
	}
	
}
