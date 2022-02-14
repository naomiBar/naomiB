package coupons.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coupons.core.entities.Company;
import coupons.core.services.AdminService;

@RestController
@RequestMapping("/admin") //http://localhost:8080/admin
public class AdminController extends ClientController {

	@Autowired
	private AdminService service;
	
	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@PostMapping
	public int addCompany(@RequestBody Company company) {
		try {
			return this.service.addCompany(company);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addCompany2(@RequestBody Company company) {
		try {
			return ResponseEntity.ok("company's id: " + this.service.addCompany(company));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

//	public updateCompany(Company company) {
//	public deleteCompany(int companyId) {
//	public getOneCompany(int companyId) {
//	public getAllCompanies() {
	
//	public addCustomer(Customer customer) {
//	public updateCustomer(Customer customer) {
//	public deleteCustomer(int customerId) {
//	public getOneCustomer(int customerId) {
//	public getAllCustomers() {
}
