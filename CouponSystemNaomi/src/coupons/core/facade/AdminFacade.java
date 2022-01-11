package coupons.core.facade;

import java.util.List;

import coupons.core.beans.Company;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class AdminFacade extends ClientFacade {

	public AdminFacade() throws CouponSystemException {
		super();
	}

	private final String email = "admin@admin.com";
	private final String password = "admin";

	@Override
	public boolean login(String email, String password) {
		return email.equals(this.email) && password.equals(this.password);
	}

	public void addCompany(Company company) throws CouponSystemException {
		if (company == null || company.getName() == null || company.getEmail() == null
				|| company.getPassword() == null) {
			throw new CouponSystemException("addCompany failed - impossible add company with null features");
		}
		if (companiesDao.isCompanyExistsByNameOrEmail(company.getName(), company.getEmail())) {
			throw new CouponSystemException("addCompany failed - name or email already exist");
		}
		companiesDao.addCompany(company);
	}

	public void updateCompany(Company company) throws CouponSystemException {
		if (company == null || company.getName() == null || company.getEmail() == null
				|| company.getPassword() == null) {
			throw new CouponSystemException("updateCompany failed - impossible update company with null features");
		}
		if (!companiesDao.isCompanyExists(company.getId(), company.getName())) {
			throw new CouponSystemException(
					"updateCompany failed - impossible update company if id and name of company not exist");
		}
		companiesDao.updateCompany(company);
	}

	public void deleteCompany(int companyId) throws CouponSystemException {
		couponsDao.deleteCompanyCouponPurchase(companyId);
		couponsDao.deleteCouponsOfCompany(companyId);
		companiesDao.deleteCompany(companyId);
	}

	public Company getOneCompany(int companyId) throws CouponSystemException {
		return companiesDao.getOneCompany(companyId);
	}

	public List<Company> getAllCompanies() throws CouponSystemException {
		return companiesDao.getAllCompanies();
	}

	public void addCustomer(Customer customer) throws CouponSystemException {
		if (customer == null || customer.getFirstName() == null || customer.getLastName() == null
				|| customer.getEmail() == null || customer.getPassword() == null) {
			throw new CouponSystemException("addCustomer failed - impossible add customer with null features");
		}
		if (customersDao.isCustomerExistsByEmail(customer.getEmail())) {
			throw new CouponSystemException("addCustomer failed - email already exist");
		}
		customersDao.addCustomer(customer);
	}

	public void updateCustomer(Customer customer) throws CouponSystemException {
		if (customer == null || customer.getFirstName() == null || customer.getLastName() == null
				|| customer.getEmail() == null || customer.getPassword() == null) {
			throw new CouponSystemException("updateCustomer failed - impossible update customer with null features");
		}
		if (!customersDao.isCustomerExistsById(customer.getId())) {
			throw new CouponSystemException(
					"updateCompany failed - impossible update company if id of customer not exist");
		}
		customersDao.updateCustomer(customer);
	}

	public void deleteCustomer(int customerId) throws CouponSystemException {
		customersDao.deleteCustomerCouponPurchase(customerId);
		customersDao.deleteCustomer(customerId);
	}

	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		return customersDao.getOneCustomer(customerId);
	}

	public List<Customer> getAllCustomers() throws CouponSystemException {
		return customersDao.getAllCustomers();
	}
}
