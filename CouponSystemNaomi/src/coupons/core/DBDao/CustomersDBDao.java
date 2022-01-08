package coupons.core.DBDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coupons.core.beans.Customer;
import coupons.core.dao.CustomersDao;
import coupons.core.exceptions.CouponSystemException;

public class CustomersDBDao implements CustomersDao{
	
	private ConnectionPool connectionPool;
	
	public CustomersDBDao() throws CouponSystemException {
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public boolean isCustomerExists(String email, String password) throws CouponSystemException {
		String sql = "select id from CUSTOMERS where `email` =  ? AND `password` = ?";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			connectionPool.restoreConnection(con);
			if(rs.next()) {
//				System.out.println("rs: " + rs.getInt(sql));
				return true;
			}
		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExists failed", e);
		}
	return false;
	}

	@Override
	public void addCustomer(Customer customer) throws CouponSystemException {
		String sql = "insert into CUSTOMERS values(0, ?, ?, ?, ?)";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.executeUpdate();
			connectionPool.restoreConnection(con);
		} catch (SQLException e) {
			throw new CouponSystemException("addCustomer failed", e);
		}		
	}

	@Override
	public void updateCustomer(Customer customer) throws CouponSystemException {
		String sql = "update CUSTOMERS set `first_name` = ?, `last_name` = ?, `email` = ?, `password` = ? where `id` = ?";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.setInt(5, customer.getId());
			connectionPool.restoreConnection(con);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("update customer " + customer.getId() + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("updateCustomer failed", e);
		}		
	}

	@Override
	public void deleteCustomer(int customerId) throws CouponSystemException {
		String sql = "delete from CUSTOMERS where `id` = ?";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customerId);
			connectionPool.restoreConnection(con);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("delete customer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCustomer failed", e);
		}	}

	@Override
	public ArrayList<Customer> getAllCustomers() throws CouponSystemException {
		ArrayList<Customer>  customers= new ArrayList<>();
		String sql = "select * from CUSTOMERS";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			connectionPool.restoreConnection(con);
			while (rs.next()) {
				customers.add(new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_Name"), rs.getString("email"), rs.getString("password")));
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getAllCustomers failed", e);
		}
		return customers;
	}
	

	@Override
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		String sql = "select * from CUSTOMERS where id = ?";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			connectionPool.restoreConnection(con);
			if (rs.next()) {
				return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"));
			} else {
				throw new CouponSystemException("read customer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCustomer failed", e);
		}
	}
}
