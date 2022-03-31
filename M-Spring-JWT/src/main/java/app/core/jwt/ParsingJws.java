package app.core.jwt;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class ParsingJws {

	public static void main(String[] args) {
		
		//creating the key:
		// 1.set the secret:
		String secretKey = "123456789a123456789a123456789a123456789a123";
		// 2.decode to Base-64:
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKey.getBytes());
		// 3.choose the algorithm:
		String algorithm = SignatureAlgorithm.HS256.getJcaName();
		// 4.create the key:
		Key key = new SecretKeySpec(secretKeyDecoded, algorithm);
		
		
		Instant now = Instant.now();
		Instant expiration = now.plus(5, ChronoUnit.MINUTES);
		
		//create a token
		String jws = Jwts.builder()
				.setSubject("aaa@mail.com") //sub => to recognize the client
				.setIssuedAt(Date.from(now)) //iat => start date 
				.setExpiration(Date.from(expiration)) //exp => end date 
				.claim("clientType", "Customer")
				.claim("firstName", "Naomi")
				.claim("lastName", "Bar")
				.claim("address", "Jerusalem, Israel")
				.signWith(key)
				.compact();
		System.out.println(jws);
		
		//get a parser
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		//parse the token and get the parsed JWT
		Jws<Claims> jwt = jwtParser.parseClaimsJws(jws);
		//print data
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());
		System.out.println(jwt.getSignature());

	}
}
