package coupons.core.DBDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.dao.CompaniesDao;
import coupons.core.exceptions.CouponSystemException;

public class CompaniesDBDao implements CompaniesDao{
	
	private ConnectionPool connectionPool;
	
	public CompaniesDBDao() throws CouponSystemException {
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public boolean isCompanyExists(String email, String password) throws CouponSystemException{
			String sql = "select id from COMPANIES where `email` =  ? AND `password` = ?";
			Connection con = connectionPool.getConnection();
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				connectionPool.restoreConnection(con);
				if(rs.next()) {
//					System.out.println("rs: " + rs.getInt(sql));
					return true;
				}
			} catch (SQLException e) {
				throw new CouponSystemException("isCompanyExists failed", e);
			}
		return false;
	}

	@Override
	public void addCompany(Company company) throws CouponSystemException {
		String sql = "insert into COMPANIES values(0, ?, ?, ?)";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.executeUpdate();
			connectionPool.restoreConnection(con);
		} catch (SQLException e) {
			throw new CouponSystemException("addCompany failed", e);
		}
	}

	@Override
	public void updateCompany(Company company) throws CouponSystemException {
		String sql = "update COMPANIES set `name` = ?, `email` = ?, `password` = ? where `id` = ?";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.setInt(4, company.getId());
			connectionPool.restoreConnection(con);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("update company " + company.getId() + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("updateCompany failed", e);
		}
	}

	@Override
	public void deleteCompany(int companyId) throws CouponSystemException {
		String sql = "delete from COMPANIES where `id` = ?";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, companyId);
			connectionPool.restoreConnection(con);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("delete company " + companyId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCompany failed", e);
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Company getOneCompany(int companyId) throws CouponSystemException {
		String sql = "select * from COMPANIES where id = ?";
		Connection con = connectionPool.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, companyId);
			ResultSet rs = pstmt.executeQuery();
			connectionPool.restoreConnection(con);
			if (rs.next()) {
				return new Company(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
			} else {
				throw new CouponSystemException("read company " + companyId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCompany failed", e);
		}
	}
}
