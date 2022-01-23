package coupons.core.login;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.facade.AdminFacade;
import coupons.core.facade.ClientFacade;
import coupons.core.facade.CompanyFacade;
import coupons.core.facade.CustomerFacade;

public class LoginManager {

	private static LoginManager instance = new LoginManager();

	private LoginManager() {
	}

	public static LoginManager getInstance() {
		return instance;
	}

	public ClientFacade login(String email, String password, ClientType clientType) throws CouponSystemException {
		ClientFacade clientFacade;

		switch (clientType) {
		case ADMINISTRATOR:
			clientFacade = new AdminFacade();
			break;
		case COMPANY:
			clientFacade = new CompanyFacade();
			break;
		case CUSTOMER:
			clientFacade = new CustomerFacade();
			break;
		default:
			return null;
		}
		
		if (clientFacade.login(email, password)) {
			return clientFacade;
		}
		return null;
	}
}
