package coupons.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;
import coupons.core.services.ClientService;

@RestController
@RequestMapping("/login") //http://localhost:8080/login
public class LoginController {
	@Autowired
	private LoginManager loginManager;
	
	@PutMapping("/{clientType}/{email}/{password}")
	public String login(@PathVariable ClientType clientType, @PathVariable String email, @PathVariable String password) {
		try {
			ClientService clientService = loginManager.login(email, password, clientType);
			System.out.println(clientService);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return null;
	}
	
}
