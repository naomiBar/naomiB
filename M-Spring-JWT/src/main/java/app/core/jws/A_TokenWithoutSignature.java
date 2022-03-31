package app.core.jws;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class A_TokenWithoutSignature {
	
	public static void main(String[] args) {
		
		Instant now = Instant.now();
		Instant expiration = now.plus(3, ChronoUnit.SECONDS);
		
		String jwts = Jwts.builder()
				
				.setSubject("aaa@mail.com") //sub => to recognize the client
				
				.setIssuedAt(Date.from(now)) //iat => start date
				
				.setExpiration(Date.from(expiration)) //exp => end date
				
				.claim("clientType", "Customer")
				
				.claim("firstName", "Naomi")
				
				.claim("lastName", "Bar")
				
				.claim("address", "Jerusalem, Israel")
				
				.compact();
		
		System.out.println(jwts);
	}
}
