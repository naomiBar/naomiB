package coupons.core.facade;

import coupons.core.DBDao.CompaniesDBDao;
import coupons.core.DBDao.CouponsDBDao;
import coupons.core.DBDao.CustomersDBDao;
import coupons.core.dao.CompaniesDao;
import coupons.core.dao.CouponsDao;
import coupons.core.dao.CustomersDao;
import coupons.core.exceptions.CouponSystemException;

public abstract class ClientFacade {

	protected CompaniesDao companiesDao;
	protected CustomersDao customersDao;
	protected CouponsDao couponsDao;
	
	public ClientFacade() throws CouponSystemException {
		this.companiesDao = new CompaniesDBDao();
		this.customersDao = new CustomersDBDao();
		this.couponsDao = new CouponsDBDao();
	}
	
	/**
	 * check if a client (ADMINISTRATOR, COMPANY, CUSTOMER) can login by email and password.
	 * @param email
	 * @param password
	 * @return if the client can login true, else false
	 * @throws CouponSystemException
	 */
	public abstract boolean login(String email, String password) throws CouponSystemException;
}
