package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.aspects.LogAspectOfCoupons;
import app.core.beans.Company;
import app.core.dao.CompanyDao;
import app.core.dao.CouponDao;


@Configuration
@ComponentScan
@EnableAspectJAutoProxy //without this annotation there is no proxy 
public class AppConfigOfCoupons {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigOfCoupons.class)){
			//get the DAO beans
			CompanyDao companyDao = ctx.getBean(CompanyDao.class);
			CouponDao couponDao = ctx.getBean(CouponDao.class);
			
			//invoke methods
			companyDao.addCompany(1);
			companyDao.sayHello();
			
			couponDao.addCoupon(11);
			couponDao.doWork();
			
			companyDao.addCompany(new Company());
			companyDao.addCompany(new Company());
			companyDao.addCompany(new Company());
			LogAspectOfCoupons logAspect = ctx.getBean(LogAspectOfCoupons.class);
			System.out.println("numberOfCalls to addCompany(Company): " + logAspect.getNumberOfCalls());
		}
	}
}
