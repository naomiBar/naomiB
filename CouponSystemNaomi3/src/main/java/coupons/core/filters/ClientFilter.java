package coupons.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.jws.util.JwtUtil;
import coupons.core.login.ClientType;

public class ClientFilter implements Filter{

	private JwtUtil jwtUtil;
	
	public ClientFilter(JwtUtil jwtUtil) {
		super();
		this.jwtUtil = jwtUtil;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(">>> FILTER");
		//cast the req/resp to http:
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.addHeader("Access-Control-Allow-Headers", "*");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "*");
		
		String token = req.getHeader("token");
		if(token == null && req.getMethod().equals("OPTIONS")) {
			System.out.println("this is preflight request: " + req.getMethod());
			chain.doFilter(request, response);
		}
		if(token != null) {
			try {
				//check token validity
				//if valid forward the request to the end point
				if(!jwtUtil.isTokenValid(token)) { //isTokenValid
					System.out.println("invalid token");
					resp.sendError(HttpStatus.UNAUTHORIZED.value(), "invalid token - go to login");
					return;
				}
				
				String path = req.getRequestURI();
				ClientType clientType = this.jwtUtil.extractClient(token).getClientType();
				if(!path.contains(clientType.toString())) {
					System.out.println("invalid token - go to login");
					resp.sendError(HttpStatus.UNAUTHORIZED.value(), "invalid token - go to login");
					return;
				}
				chain.doFilter(request, response);
			
			}catch (CouponSystemException e) {
				resp.sendError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
			}
			
		}
	}
}
