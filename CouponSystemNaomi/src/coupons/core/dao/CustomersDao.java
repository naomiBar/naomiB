package coupons.core.dao;

import java.util.List;

import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public interface CustomersDao {
	
	public boolean isCustomerExists(String email, String password) throws CouponSystemException;
	public int addCustomer(Customer customer) throws CouponSystemException;
	public void updateCustomer(Customer customer) throws CouponSystemException;
	public void deleteCustomer(int customerId) throws CouponSystemException;
	public List<Customer> getAllCustomers() throws CouponSystemException;
	public Customer getOneCustomer(int customerId) throws CouponSystemException;
	public boolean isCustomerExistsId(int id) throws CouponSystemException;
	public boolean isCustomerExistsEmail(String email) throws CouponSystemException;
}
