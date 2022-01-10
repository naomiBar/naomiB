package coupons.core.dao;

import java.util.List;

import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public interface CustomersDao {
	
	public int addCustomer(Customer customer) throws CouponSystemException;
	public void updateCustomer(Customer customer) throws CouponSystemException;
	public void deleteCustomer(int customerId) throws CouponSystemException;
	public Customer getOneCustomer(int customerId) throws CouponSystemException;
	public List<Customer> getAllCustomers() throws CouponSystemException;
	public int isCustomerExistsRtnId(String email, String password) throws CouponSystemException;
	public boolean isCustomerExists(String email, String password) throws CouponSystemException;
	public boolean isCustomerExistsById(int id) throws CouponSystemException;
	public boolean isCustomerExistsByEmail(String email) throws CouponSystemException;
	public boolean isPurchaseCouponExists(int customerId, int couponId) throws CouponSystemException;
	public void deleteCustomerOfCoupons(int customerId) throws CouponSystemException;
}
