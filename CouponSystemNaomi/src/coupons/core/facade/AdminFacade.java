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

	/**
	 * adds the company and set the id of the parameter and return the id. 
	 * @param company to be added
	 * @return the generated id
	 * @throws CouponSystemException if the company's features are null or the name or email are taken
	 */
	public int addCompany(Company company) throws CouponSystemException {
		//check if company's features are not null:
		if (company == null || company.getName() == null || company.getEmail() == null
				|| company.getPassword() == null) {
			throw new CouponSystemException("addCompany failed - impossible add company with null features");
		}
		//check if company's name or email are not taken:
		if (companiesDao.isCompanyExistsByNameOrEmail(company.getName(), company.getEmail())) {
			throw new CouponSystemException("addCompany failed - name or email already exist");
		}
		return companiesDao.addCompany(company);
	}

	/**
	 * update a company
	 * @param company to be updated
	 * @throws CouponSystemException if the company's features are null or the id and name not exits
	 */
	public void updateCompany(Company company) throws CouponSystemException {
		//check if company's features are not null:
		if (company == null || company.getName() == null || company.getEmail() == null
				|| company.getPassword() == null) {
			throw new CouponSystemException("updateCompany failed - impossible update company with null features");
		}
		//check if company's id and name are exits:
		if (!companiesDao.isCompanyExistsByIdAndName(company.getId(), company.getName())) {
			throw new CouponSystemException(
					"updateCompany failed - impossible update company if id and name of company not exist");
		}
		companiesDao.updateCompany(company);
	}

	/**
	 * delete a company and these coupons
	 * @param companyId
	 * @throws CouponSystemException
	 */
	public void deleteCompany(int companyId) throws CouponSystemException {
		//check if coupon purchase exists by companyId
		if(companiesDao.isCouponsPurchaseExistsByCompanyId(companyId)) {
			System.out.println("isCouponsPurchaseExistsByCompanyId");
			companiesDao.deleteCouponsPurchaseByCompanyId(companyId);			
		}
		//check if coupons exists by companyId
		if(companiesDao.isCouponsExistsByCompanyId(companyId)) {
			System.out.println("isCouponsExistsByCompanyId");
			companiesDao.deleteCouponsByCompanyId(companyId);			
		}
		companiesDao.deleteCompany(companyId);
	}

	/**
	 * returns the company by id.
	 * @param companyId
	 * @return the company
	 * @throws CouponSystemException if company's id not found
	 */
	public Company getOneCompany(int companyId) throws CouponSystemException {
		return companiesDao.getOneCompany(companyId);
	}

	/**
	 * returns all the companies in the DB.
	 * @return a list of all companies
	 * @throws CouponSystemException
	 */
	public List<Company> getAllCompanies() throws CouponSystemException {
		return companiesDao.getAllCompanies();
	}

	/**
	 * adds the customer and set the id of the parameter and return the id. 
	 * @param customer to be added
	 * @return the generated id
	 * @throws CouponSystemException if the customer's features are null or the email is taken
	 */
	public int addCustomer(Customer customer) throws CouponSystemException {
		//check if customer features are not null:
		if (customer == null || customer.getFirstName() == null || customer.getLastName() == null
				|| customer.getEmail() == null || customer.getPassword() == null) {
			throw new CouponSystemException("addCustomer failed - impossible add customer with null features");
		}
		//check if customer email is not taken:
		if (customersDao.isCustomerExistsByEmail(customer.getEmail())) {
			throw new CouponSystemException("addCustomer failed - email already exist");
		}
		return customersDao.addCustomer(customer);
	}

	/**
	 * update a customer.
	 * @param customer to be updated
	 * @throws CouponSystemException if the customer's features are null.
	 */
	public void updateCustomer(Customer customer) throws CouponSystemException {
		//check if customer features are not null:
		if (customer == null || customer.getFirstName() == null || customer.getLastName() == null
				|| customer.getEmail() == null || customer.getPassword() == null) {
			throw new CouponSystemException("updateCustomer failed - impossible update customer with null features");
		}
		customersDao.updateCustomer(customer);
	}

	/**
	 * delete a customer and these coupons.
	 * @param customerId
	 * @throws CouponSystemException
	 */
	public void deleteCustomer(int customerId) throws CouponSystemException {
		//check if coupon purchase exists by customerId
		if(customersDao.isCouponsPurchaseExistsByCustomerId(customerId)) {
			System.out.println("isCouponExistsByCustomerId");
			customersDao.deleteCouponsPurchaseByCustomerId(customerId);			
		}
		customersDao.deleteCustomer(customerId);
	}

	/**
	 * returns the customer by id.
	 * @param customerId
	 * @return the customer 
	 * @throws CouponSystemException if customer's id not found
	 */
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		return customersDao.getOneCustomer(customerId);
	}

	/**
	 * returns all the customers in the DB.
	 * @return a list of all customers
	 * @throws CouponSystemException
	 */
	public List<Customer> getAllCustomers() throws CouponSystemException {
		return customersDao.getAllCustomers();
	}
}
