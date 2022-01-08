package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public interface CompaniesDao {
	
	public boolean isCompanyExists(String email, String password) throws CouponSystemException;
	public void addCompany(Company company) throws CouponSystemException;
	public void updateCompany(Company company) throws CouponSystemException;
	public void deleteCompany(int companyId) throws CouponSystemException;
	public ArrayList<Company> getAllCompanies();
	public Company getOneCompany(int companyId) throws CouponSystemException;
}
