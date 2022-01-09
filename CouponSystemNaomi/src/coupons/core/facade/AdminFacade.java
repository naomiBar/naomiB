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
		if (!companiesDao.isCompanyExistsName(company.getName())
				&& !companiesDao.isCompanyExistsEmail(company.getEmail())) {
			companiesDao.addCompany(company);
		}
	}

	public void updateCompany(Company company) throws CouponSystemException {
		if (companiesDao.isCompanyExistsId(company.getId()) 
				&& companiesDao.isCompanyExistsName(company.getName())) {
			companiesDao.updateCompany(company);
		}
	}

	public void deleteCompany(int companyId) throws CouponSystemException {
		companiesDao.deleteCompany(companyId);
		couponsDao.deleteCouponsOfCompany(companyId);
	}

	public List<Company> getAllCompanies() throws CouponSystemException {
		return companiesDao.getAllCompanies();
	}

	public Company getOneCompany(int companyId) throws CouponSystemException {
		return companiesDao.getOneCompany(companyId);
	}

	public void addCustomer(Customer customer) throws CouponSystemException {
		if(!customersDao.isCustomerExistsEmail(customer.getEmail())) {
			customersDao.addCustomer(customer);
		}
	}

	public void updateCustomer(Customer customer) throws CouponSystemException {
		if(customersDao.isCustomerExistsId(customer.getId())) {
			customersDao.updateCustomer(customer);
		}
	}

	public void deleteCustomer(int customerId) {

	}

	public List<Customer> getAllCustomers() {
		return null;
	}

	public Customer getOneCustomer(int customerId) {
		return null;
	}

}
