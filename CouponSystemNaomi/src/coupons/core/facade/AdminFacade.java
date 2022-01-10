package coupons.core.facade;

import java.util.List;

import coupons.core.beans.Company;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class AdminFacade extends ClientFacade {

	public AdminFacade() throws CouponSystemException {
		super();
	}

	@Override
	public boolean login(String email, String password) {
		return email.equals("admin@admin.com") && password.equals("admin");
	}

	public int addCompany(Company company) throws CouponSystemException {
		if (company != null && company.getName() != null && company.getEmail() != null && company.getPassword() != null
				&& !companiesDao.isCompanyExistsByName(company.getName())
				&& !companiesDao.isCompanyExistsByEmail(company.getEmail())) {
			return companiesDao.addCompany(company);
		}
		return -1;
	}

	public void updateCompany(Company company) throws CouponSystemException {
		if (companiesDao.isCompanyExists(company.getId(), company.getName())) {
			if(company.getEmail() != null && company.getPassword() != null) {
				companiesDao.updateCompany(company);				
			}
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

	public int addCustomer(Customer customer) throws CouponSystemException {
		if (customer != null && customer.getFirstName() != null && customer.getLastName() != null
				&& customer.getEmail() != null && customer.getPassword() != null
				&& !customersDao.isCustomerExistsByEmail(customer.getEmail())) {
			return customersDao.addCustomer(customer);
		}
		return -1;
	}

	public void updateCustomer(Customer customer) throws CouponSystemException {
		if (customersDao.isCustomerExistsById(customer.getId())) {
			if(customer.getFirstName() != null && customer.getLastName() != null
				&& customer.getEmail() != null && customer.getPassword() != null) {
				customersDao.updateCustomer(customer);				
			}
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
