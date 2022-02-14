package coupons.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coupons.core.entities.Company;
import coupons.core.entities.Customer;
import coupons.core.exceptions.CouponSystemException;

@Service
@Transactional
public class AdminService extends ClientService{

	@Value("${service.admin.email:X}")
	private String email;
	@Value("${service.admin.password:X}")
	private String password;
	
	
	@Override 
	public boolean login(String email, String password) {
		return this.email.equals(email) && this.password.equals(password);
	}
	
	
	/**
	 * adds the company and return the id. 
	 * @param company to be added
	 * @return the generated id
	 * @throws CouponSystemException if the company's features are null,
	 * 			 or the company's id already exists,
	 * 			 or the name or email are taken
	 */
	public int addCompany(Company company) throws CouponSystemException {
		//check if company's features are not null:
		if (company.getName() == null || company.getEmail() == null
				|| company.getPassword() == null) {
			throw new CouponSystemException("addCompany failed - impossible add company with null features");
		}
		//check if company's id already exists:
		if(companyRepository.existsById(company.getId())) {
			throw new CouponSystemException("addCompany failed - company id " + company.getId() + " already exists");
		}
		//check if company's name or email are not taken:
		if (companyRepository.existsByNameOrEmail(company.getName(), company.getEmail())) {
			throw new CouponSystemException("addCompany failed - name or email already exists");
		}
		return companyRepository.save(company).getId();
	}
	
	
	/**
	 * update a company
	 * @param company to be updated
	 * @throws CouponSystemException if the company's features are null or the id and name not exists
	 */
	public void updateCompany(Company company) throws CouponSystemException {
		//check if company's features are not null:
		if (company == null || company.getName() == null || company.getEmail() == null
				|| company.getPassword() == null) {
			throw new CouponSystemException("updateCompany failed - impossible update company with null features");
		}
		//check if company's id and name are exists:
		if(companyRepository.existsByIdAndName(company.getId(), company.getName())) {
			companyRepository.save(company);
		}
		else {
			throw new CouponSystemException("updateCompany failed - impossible update company if id and name of company not exists");
		}
	}
	
	
	/**
	 * delete a company (and these coupons)
	 * @param companyId
	 * @throws CouponSystemException if company's id not found
	 */
	public void deleteCompany(int companyId) throws CouponSystemException {
		//check if company's id exists:
		if(companyRepository.existsById(companyId)) {
			companyRepository.deleteById(companyId);
		}else {
			throw new CouponSystemException("deleteCompany failed - company id " + companyId + " NOT found");
		}
	}
	
	
	/**
	 * returns the company by id.
	 * @param companyId
	 * @return the company
	 * @throws CouponSystemException if company's id not found
	 */
	public Company getOneCompany(int companyId) throws CouponSystemException {
		Optional<Company> opt = companyRepository.findById(companyId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CouponSystemException("getOneCompany failed - company id " + companyId + " NOT found");
	}
	
	
	/**
	 * returns all the companies in the DB.
	 * @return a list of all companies
	 */
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	
	/**
	 * adds the customer and return the id. 
	 * @param customer to be added
	 * @return the generated id
	 * @throws CouponSystemException if the customer's features are null,
	 * 				or the customer's id already exists,
	 *  			or the email is taken
	 */
	public int addCustomer(Customer customer) throws CouponSystemException {
		//check if customer features are not null:
		if (customer.getFirstName() == null || customer.getLastName() == null
				|| customer.getEmail() == null || customer.getPassword() == null) {
			throw new CouponSystemException("addCustomer failed - impossible add customer with null features");
		}
		//check if customer's id already exists:
		if(customerRepository.existsById(customer.getId())) {
			throw new CouponSystemException("addCustomer failed - customer id " + customer.getId() + " already exists");
		}
		//check if customer email is not taken:
		if (customerRepository.existsByEmail(customer.getEmail())) {
			throw new CouponSystemException("addCustomer failed - email already exists");
		}
		return customerRepository.save(customer).getId();
	}
	
	

	/**
	 * update a customer.
	 * @param customer to be updated
	 * @throws CouponSystemException if the customer's features are null or the id not exists
	 */
	public void updateCustomer(Customer customer) throws CouponSystemException {
		//check if customer features are not null:
		if (customer.getFirstName() == null || customer.getLastName() == null
				|| customer.getEmail() == null || customer.getPassword() == null) {
			throw new CouponSystemException("updateCustomer failed - impossible update customer with null features");
		}
		//check if customer's id exists:
		if(customerRepository.existsById(customer.getId())) {
			customerRepository.save(customer);
		}
		else {
			throw new CouponSystemException("updateCustomer failed - impossible update customer if id of customer not exists");
		}
	}

		
	/**
	 * delete a customer (and these coupons).
	 * @param customerId
	 * @throws CouponSystemException if customer's id not found
	 */
	public void deleteCustomer(int customerId) throws CouponSystemException {
		//check if customer's id exists:
		if(customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
		}else {
			throw new CouponSystemException("deleteCustomer failed - customer id " + customerId + " NOT found");
		}
	}

	/**
	 * returns the customer by id.
	 * @param customerId
	 * @return the customer 
	 * @throws CouponSystemException if customer's id not found
	 */
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CouponSystemException("getOneCustomer failed - customer id " + customerId + " NOT found");
	}

	/**
	 * returns all the customers in the DB.
	 * @return a list of all customers
	 */
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}


}
