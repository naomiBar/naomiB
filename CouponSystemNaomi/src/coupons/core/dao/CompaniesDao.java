package coupons.core.dao;

import java.util.List;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public interface CompaniesDao {

	/**
	 * adds the company and set the id of the parameter and return the id.
	 * @param company to be added
	 * @return the generated id
	 * @throws CouponSystemException
	 */
	public int addCompany(Company company) throws CouponSystemException;
	
	/**
	 * update a company.
	 * @param company to be updated
	 * @throws CouponSystemException if company's id not found
	 */
	public void updateCompany(Company company) throws CouponSystemException;
	
	/**
	 * delete a company by id.
	 * @param companyId 
	 * @throws CouponSystemException if company's id not found
	 */
	public void deleteCompany(int companyId) throws CouponSystemException;
	
	/**
	 * return the company by id.
	 * @param companyId
	 * @return the company
	 * @throws CouponSystemException if company's id not found
	 */
	public Company getOneCompany(int companyId) throws CouponSystemException;
	
	/**
	 * return all the companies in the DB.
	 * @return a list of all companies
	 * @throws CouponSystemException
	 */
	public List<Company> getAllCompanies() throws CouponSystemException;
	
	/**
	 * check if a company exists by email and password,
	 * its for a company to login.
	 * @param email
	 * @param password
	 * @return the company's id if exists, else -1
	 * @throws CouponSystemException
	 */
	public int isCompanyExistsRtnId(String email, String password) throws CouponSystemException;
	
	/**
	 * check if a company exists by name or email,
	 * its for add a company.
	 * @param name
	 * @param email
	 * @return true if company exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCompanyExistsByNameOrEmail(String name, String email) throws CouponSystemException;
	
	/**
	 * check if a company exists by id and name,
	 * its for update a company.
	 * @param id
	 * @param name
	 * @return true if company exist , else false
	 * @throws CouponSystemException
	 */
	public boolean isCompanyExistsByIdAndName(int id, String name) throws CouponSystemException;
	
	/**
	 * check if couponsPurchase exist by company,
	 * its for delete company's coupons and the company.
	 * @param companyId
	 * @return true if couponsPurchase exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponsPurchaseExistsByCompanyId(int companyId) throws CouponSystemException;
	
	/**
	 * delete couponsPurchase by companyId,
	 * before delete company's coupons and the company.
	 * @param companyId
	 * @throws CouponSystemException if company's id not found
	 */
	public void deleteCouponsPurchaseByCompanyId(int companyId) throws CouponSystemException;
	
	/**
	 * check if coupons exist by company,
	 * its for delete a company.
	 * @param companyId
	 * @return true if coupons exist, else false
	 * @throws CouponSystemException
	 */
	public boolean isCouponsExistsByCompanyId(int companyId) throws CouponSystemException;
	
	/**
	 * delete coupons by companyId,
	 * before delete the company.
	 * @param companyId
	 * @throws CouponSystemException if company's id not found
	 */
	public void deleteCouponsByCompanyId(int companyId) throws CouponSystemException;
}
