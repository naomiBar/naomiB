package app.core.dao;

import org.springframework.stereotype.Component;

import app.core.beans.Company;

@Component
public class CompanyDao {

	//Business methods to be intercepted as joinpoints
	public void addCompany(int id) {
		System.out.println("company " + id + " added");
	}
	
	public void addCompany(Company company) {
		System.out.println("company added");
	}
	
	public void sayHello() {
		System.out.println("hello from company DAO");
	}
}
