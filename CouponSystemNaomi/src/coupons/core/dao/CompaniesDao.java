package coupons.core.dao;

import java.util.List;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public interface CompaniesDao {
	
	public boolean isCompanyExists(String email, String password) throws CouponSystemException;
	public int addCompany(Company company) throws CouponSystemException;
	public void updateCompany(Company company) throws CouponSystemException;
	public void deleteCompany(int companyId) throws CouponSystemException;
	public List<Company> getAllCompanies() throws CouponSystemException;
	public Company getOneCompany(int companyId) throws CouponSystemException;
	public boolean isCompanyExistsId(int id) throws CouponSystemException;
	public boolean isCompanyExistsName(String name) throws CouponSystemException;
	public boolean isCompanyExistsEmail(String email) throws CouponSystemException;
}
