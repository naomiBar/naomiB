package coupons.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.jws.util.JwtUtil;
import coupons.core.jws.util.JwtUtil.ClientDetails;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;
import coupons.core.services.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/login") //http://localhost:8080/login
public class LoginController {
	
	@Autowired
	private LoginManager loginManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping
	public String login(@RequestParam ClientType clientType, @RequestParam String email, @RequestParam String password) {
		
		ClientService clientService;
		try {
			System.out.println(">>");
			clientService = loginManager.login(email, password, clientType);
			if(clientService instanceof ClientService) {
				ClientDetails clientDetails = new ClientDetails(email, clientType, clientService.getClientId());
				System.out.println("=================");
				System.out.println(jwtUtil.generateToken(clientDetails));
				System.out.println("=================");
				return jwtUtil.generateToken(clientDetails);
			}
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "failed to login - please try again");
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
		
	}
}
