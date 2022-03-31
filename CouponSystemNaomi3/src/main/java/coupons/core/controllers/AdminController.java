package coupons.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import coupons.core.entities.Company;
import coupons.core.entities.Customer;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.services.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/ADMINISTRATOR")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping(path = "/addCompany")
	public int addCompany(@RequestBody Company company, @RequestHeader String token) {
		System.out.println(">>>>>company: " + company);
		try {
			return this.service.addCompany(company);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping(path = "/updateCompany")
	public void updateCompany(@RequestBody Company company, @RequestHeader String token) {
		try {
			this.service.updateCompany(company);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping(path = "/deleteCompany/{companyId}")
	public void deleteCompany(@PathVariable int companyId, @RequestHeader String token) {
		try {
			this.service.deleteCompany(companyId);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping(path = "/getOneCompany/{companyId}")
	public Company getOneCompany(@PathVariable int companyId, @RequestHeader String token) {
		try {
			return this.service.getOneCompany(companyId);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping(path = "/getAllCompanies")
	public List<Company> getAllCompanies(@RequestHeader String token) {
		return this.service.getAllCompanies();
	}
	
	@PostMapping(path = "/addCustomer")
	public int addCustomer(@RequestBody Customer customer, @RequestHeader String token) {
		try {
			return this.service.addCustomer(customer);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PutMapping(path = "/updateCustomer")
	public void updateCustomer(@RequestBody Customer customer, @RequestHeader String token) {
		try {
			this.service.updateCustomer(customer);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping(path = "/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable int customerId, @RequestHeader String token) {
		try {
			this.service.deleteCustomer(customerId);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping(path = "/getOneCustomer/{customerId}")
	public Customer getOneCustomer(@PathVariable int customerId, @RequestHeader String token) {
		try {
			return this.service.getOneCustomer(customerId);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping(path = "/getAllCustomers")
	public List<Customer> getAllCustomers(@RequestHeader String token) {
		return this.service.getAllCustomers();
	}
}
