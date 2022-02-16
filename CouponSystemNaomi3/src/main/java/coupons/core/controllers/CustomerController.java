package coupons.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coupons.core.entities.Category;
import coupons.core.entities.Coupon;
import coupons.core.entities.Customer;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.services.CustomerService;

@RestController
@RequestMapping("/customer") //http://localhost:8080/customer
public class CustomerController extends ClientController {

	@Autowired
	private CustomerService service;
	
	@PutMapping(path = "/login/{email}/{password}")
	@Override
	public boolean login(@PathVariable String email, @PathVariable String password) {
		return this.service.login(email, password);
	}
	
	@GetMapping(path = "/getCustomerDetails")
	public Customer getCustomerDetails() {
//		this.service.setCustomerId(5);
		try {
			return this.service.getCustomerDetails();
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());	
		}
	}
	
	@PostMapping(path = "/purchaseCoupon/{couponId}")
	public void purchaseCoupon(@PathVariable int couponId) {
//		this.service.setCustomerId(6);
		try {
			this.service.purchaseCoupon(couponId);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());	
		}
		
	}
	
	@GetMapping(path = "/getCustomerCoupons")
	public List<Coupon> getCustomerCoupons() {
//		this.service.setCustomerId(5);
		return this.service.getCustomerCoupons();
	}
	
	@GetMapping(path = "/getCompanyCouponsByCategory/{category}")
	public List<Coupon> getCustomerCoupons(@PathVariable Category category) {
//		this.service.setCustomerId(5);
		return this.service.getCustomerCoupons(category);
	}
	
	@GetMapping(path = "/getCompanyCouponsByMaxPrice/{maxPrice}")
	public List<Coupon> getCustomerCoupons(@PathVariable double maxPrice) {
//		this.service.setCustomerId(5);
		return this.service.getCustomerCoupons(maxPrice);
	}
	
}
