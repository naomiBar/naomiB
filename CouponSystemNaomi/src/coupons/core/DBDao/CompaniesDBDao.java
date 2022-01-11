package coupons.core.DBDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coupons.core.beans.Company;
import coupons.core.dao.CompaniesDao;
import coupons.core.exceptions.CouponSystemException;

public class CompaniesDBDao implements CompaniesDao {

	private ConnectionPool connectionPool;

	public CompaniesDBDao() throws CouponSystemException {
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public int addCompany(Company company) throws CouponSystemException {
		String sql = "insert into COMPANIES values(0, ?, ?, ?)";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			company.setId(id);
			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("addCompany failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void updateCompany(Company company) throws CouponSystemException {
		String sql = "update COMPANIES set `name` = ?, `email` = ?, `password` = ? where `id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.setInt(4, company.getId());
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("update company " + company.getId() + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("updateCompany failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void deleteCompany(int companyId) throws CouponSystemException {
		String sql = "delete from COMPANIES where `id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("delete company " + companyId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCompany failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public Company getOneCompany(int companyId) throws CouponSystemException {
		String sql = "select * from COMPANIES where id = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Company(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("password"));
			} else {
				throw new CouponSystemException("read company " + companyId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCompany failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public List<Company> getAllCompanies() throws CouponSystemException {
		String sql = "select * from COMPANIES";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			List<Company> companies = new ArrayList<>();
			while (rs.next()) {
				companies.add(new Company(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("password")));
			}
			return companies;
		} catch (SQLException e) {
			throw new CouponSystemException("getAllCompanies failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	
	@Override
	public int isCompanyExistsRtnId(String email, String password) throws CouponSystemException {
		String sql = "select id from COMPANIES where `email` =  ? AND `password` = ?";
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
			throw new CouponSystemException("isCompanyExistsRtnId failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public boolean isCompanyExists(String email, String password) throws CouponSystemException {
		if (isCompanyExistsRtnId(email, password) != -1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isCompanyExists(int id, String name) throws CouponSystemException {
		String sql = "select id from COMPANIES where `id` =  ? AND `name` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCompanyExistsById failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public boolean isCompanyExistsByNameOrEmail(String name, String email) throws CouponSystemException {
		String sql = "select id from COMPANIES where `name` =  ? Or `email` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCompanyExistsByNameOrEmail failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
}
