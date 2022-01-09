package coupons.core.facade;

import coupons.core.dao.CompaniesDao;
import coupons.core.dao.CouponsDao;
import coupons.core.dao.CustomersDao;

public abstract class ClientFacade {

	protected CompaniesDao companiesDao;
	protected CustomersDao customersDao;
	protected CouponsDao couponsDao;
	
	public abstract boolean login(String email, String password);
}
