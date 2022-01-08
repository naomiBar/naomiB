package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Customer;

public interface CustomersDao {
	
	public boolean isCustomerExists(String email, String password);
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public ArrayList<Customer> getAllCustomers();
	public Customer getOneCustomer(int customerId);
}
