package coupons.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coupons.core.repositories.CompanyRepository;
import coupons.core.repositories.CouponRepository;
import coupons.core.repositories.CustomerRepository;

@Service
@Transactional
public abstract class ClientService {

	@Autowired
	protected CompanyRepository companyRepository;
	@Autowired
	protected CustomerRepository customerRepository;
	@Autowired
	protected CouponRepository couponRepository;
	
	/**
	 * check if a client (ADMINISTRATOR, COMPANY, CUSTOMER) can login by email and password.
	 * @param email
	 * @param password
	 * @return true if the client can login, else false
	 */
	public abstract boolean login(String email, String password);
}
