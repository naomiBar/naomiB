package app.core.jws;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class D_TokenWithSignature {
	
	public static void main(String[] args) {
		
		//1.set the secret:
		String secretKey = "123456789a123456789a123456789a123456789a123";
		//2.decode to Base-64:
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKey.getBytes());
		//3.choose the algorithm:
		String algorithm = SignatureAlgorithm.HS256.getJcaName();
		//4.create the key:
		Key key = new SecretKeySpec(secretKeyDecoded, algorithm);
		
		Instant now = Instant.now();
		Instant expiration = now.plus(5, ChronoUnit.MINUTES);
		
		String jwts = Jwts.builder()
				.setSubject("aaa@mail.com") //sub => to recognize the client
				.setIssuedAt(Date.from(now)) //iat => start date 
				.setExpiration(Date.from(expiration)) //exp => end date 
				.claim("clientType", "Customer")
				.claim("firstName", "Naomi")
				.claim("lastName", "Bar")
				.claim("address", "Jerusalem, Israel")
				.signWith(key)
				.compact();
		System.out.println(jwts);
	}
}
