package coupons.core.services;

import org.springframework.beans.factory.annotation.Autowired;

import coupons.core.repositories.CompanyRepository;
import coupons.core.repositories.CouponRepository;
import coupons.core.repositories.CustomerRepository;


public abstract class ClientService {


	@Autowired
	protected CompanyRepository companyRepository;
	@Autowired
	protected CustomerRepository customerRepository;
	@Autowired
	protected CouponRepository couponRepository;
	
	protected int clientId;
	
	public int getClientId() {
		return clientId;
	}

	/**
	 * check if a client (ADMINISTRATOR, COMPANY, CUSTOMER) can login by email and password.
	 * @param email
	 * @param password
	 * @return true if the client can login, else false
	 */
	public abstract boolean login(String email, String password);
}
