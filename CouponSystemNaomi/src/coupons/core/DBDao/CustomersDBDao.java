package coupons.core.DBDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coupons.core.beans.Customer;
import coupons.core.dao.CustomersDao;
import coupons.core.exceptions.CouponSystemException;

public class CustomersDBDao implements CustomersDao {

	private ConnectionPool connectionPool;

	public CustomersDBDao() throws CouponSystemException {
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public int addCustomer(Customer customer) throws CouponSystemException {
		String sql = "insert into CUSTOMERS values(0, ?, ?, ?, ?)";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			customer.setId(id);
			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("addCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws CouponSystemException {
		String sql = "update CUSTOMERS set `first_name` = ?, `last_name` = ?, `email` = ?, `password` = ? where `id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.setInt(5, customer.getId());
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("update customer " + customer.getId() + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("updateCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void deleteCustomer(int customerId) throws CouponSystemException {
		String sql = "delete from CUSTOMERS where `id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("delete customer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		String sql = "select * from CUSTOMERS where id = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getString("password"));
			} else {
				throw new CouponSystemException("read customer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws CouponSystemException {
		String sql = "select * from CUSTOMERS";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			List<Customer> customers = new ArrayList<>();
			while (rs.next()) {
				customers.add(new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_Name"),
						rs.getString("email"), rs.getString("password")));
			}
			return customers;
		} catch (SQLException e) {
			throw new CouponSystemException("getAllCustomers failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public int isCustomerExistsRtnId(String email, String password) throws CouponSystemException {
		String sql = "select id from CUSTOMERS where `email` =  ? AND `password` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
			return -1;
		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExistsRtnId failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public boolean isCustomerExists(String email, String password) throws CouponSystemException {
		if (isCustomerExistsRtnId(email, password) != -1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isCustomerExistsById(int id) throws CouponSystemException {
		String sql = "select id from CUSTOMERS where `id` =  ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExistsById failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public boolean isCustomerExistsByEmail(String email) throws CouponSystemException {
		String sql = "select id from CUSTOMERS where `email` =  ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExistsByEmail failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public boolean isPurchaseCouponExists(int customerId, int couponId) throws CouponSystemException {
		String sql = "select * from CUSTOMERS_VS_COUPONS where `customer_id` =  ? AND `coupon_id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isPurchaseCouponExists failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public void deleteCustomerCouponPurchase(int customerId) throws CouponSystemException {
		String sql = "delete from CUSTOMERS_VS_COUPONS where `customer_id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException(
						"deleteCustomerCouponPurchase failed: customerId-" + customerId + "  not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCustomerCouponPurchase failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
}
