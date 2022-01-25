package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;
import app.core.repositories.CompanyRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Company company = new Company(0, "AAA", "aaa@mail", null);
		company.setAddress(new Address(0, "Israel", "Jerusalem", "Ben yehouda", 5));
		
		System.out.println(">>>>> " + company);
		
		//save company to DB
		CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
		company = companyRepo.save(company);
		
		System.out.println(">>>>> " + company);
		
		// uni directional:

		// we can get the address from the company
		Address address = company.getAddress();
		System.out.println(address);

		// we can NOT get the company from the address
		// Company c = address.getCompany();
	}

}
