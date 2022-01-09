package coupons.core.facade;

import java.util.List;

import coupons.core.beans.Company;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class AdminFacade extends ClientFacade {

	public AdminFacade() {
	}

	@Override
	public boolean login(String email, String password) {
		return email.equals("admin@admin.com") && password.equals("admin");
	}

	public void addCompany(Company company) throws CouponSystemException {
		if (!companiesDao.isCompanyExistsByName(company.getName())
				&& !companiesDao.isCompanyExistsByEmail(company.getEmail())) {
			companiesDao.addCompany(company);
		}
	}

	public void updateCompany(Company company) throws CouponSystemException {
		if (companiesDao.isCompanyExistsById(company.getId()) 
				&& companiesDao.isCompanyExistsByName(company.getName())) {
			companiesDao.updateCompany(company);
		}
	}

	public void deleteCompany(int companyId) throws CouponSystemException {
		companiesDao.deleteCompany(companyId);
		couponsDao.deleteCouponsOfCompany(companyId);
	}

	public Company getOneCompany(int companyId) throws CouponSystemException {
		return companiesDao.getOneCompany(companyId);
	}
	
	public List<Company> getAllCompanies() throws CouponSystemException {
		return companiesDao.getAllCompanies();
	}

	public void addCustomer(Customer customer) throws CouponSystemException {
		if(!customersDao.isCustomerExistsByEmail(customer.getEmail())) {
			customersDao.addCustomer(customer);
		}
	}

	public void updateCustomer(Customer customer) throws CouponSystemException {
		if(customersDao.isCustomerExistsById(customer.getId())) {
			customersDao.updateCustomer(customer);
		}
	}

	public void deleteCustomer(int customerId) throws CouponSystemException {
		customersDao.deleteCustomer(customerId);
		customersDao.deleteCustomerOfCoupons(customerId);
	}


	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		return customersDao.getOneCustomer(customerId);
	}

	public List<Customer> getAllCustomers() throws CouponSystemException {
		return customersDao.getAllCustomers();
	}
}
