package coupons.core.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.services.ClientService;

@Component
public class LoginManager {

	@Autowired
	private ApplicationContext ctx;
	
	

	public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
		ClientService clientService;
		switch (clientType) {
		case ADMINISTRATOR:
			clientService = ctx.getBean("adminService",ClientService.class);
			break;
		case COMPANY:
			clientService = ctx.getBean("companyService",ClientService.class);
			break;
		case CUSTOMER:
			clientService = ctx.getBean("customerService",ClientService.class);
			break;
		default:
			throw new CouponSystemException("illegal client");
		}
		if (clientService.login(email, password)) {
			return clientService;
		}
		return null;
	}
}
