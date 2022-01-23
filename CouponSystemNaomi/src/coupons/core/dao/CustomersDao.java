package coupons.core.dao;

import java.util.List;

import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public interface CustomersDao {
	
	/**
	 * adds the customer and set the id of the parameter and return the id.
	 * @param customer to be added
	 * @return the generated id
	 * @throws CouponSystemException
	 */
	public int addCustomer(Customer customer) throws CouponSystemException;
	
	/**
	 * update a customer.
	 * @param customer to be updated
	 * @throws CouponSystemException if customer's id not found
	 */
	public void updateCustomer(Customer customer) throws CouponSystemException;
	
	/**
	 * delete a customer by id.
	 * @param customerId
	 * @throws CouponSystemException if customer's id not found
	 */
	public void deleteCustomer(int customerId) throws CouponSystemException;
	
	/**
	 * return the customer by id.
	 * @param customerId
	 * @return the customer
	 * @throws CouponSystemException if customer's id not found
	 */
	public Customer getOneCustomer(int customerId) throws CouponSystemException;
	
	/**
	 * return all the customers in the DB.
	 * @return a list of all customers
	 * @throws CouponSystemException
	 */
	public List<Customer> getAllCustomers() throws CouponSystemException;
	
	/**
	 * check if a customer exists by email and password,
	 * its for a customer to login.
	 * @param email
	 * @param password
	 * @return the customer's id if exist, else -1
	 * @throws CouponSystemException
	 */
	public int isCustomerExistsRtnId(String email, String password) throws CouponSystemException;
	
	/**
	 * check if a customer exists by email,
	 * its for add a customer.
	 * @param email
	 * @return true if customer exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCustomerExistsByEmail(String email) throws CouponSystemException;
	
	
	/**
	 * check if couponsPurchase exist by customer,
	 * its for delete the customer
	 * @param customerId
	 * @return true if couponsPurchase exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponsPurchaseExistsByCustomerId(int customerId) throws CouponSystemException;
	
	/**
	 * delete couponsPurchase by customerId,
	 * before delete the customer.
	 * @param customerId
	 * @throws CouponSystemException if customer's id not found
	 */
	public void deleteCouponsPurchaseByCustomerId(int customerId) throws CouponSystemException;
}
