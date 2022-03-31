package coupons.core.jws.util;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.login.ClientType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class JwtUtil {

	private String signatureAlgorithm = SignatureAlgorithm.HS256.getJcaName();

	@Value("${jwt.util.secret.key:X}")
	private String encodedSecretKey;

	@Value("${jwt.util.chrono.unit:X}")
	private String chronoUnit;

	@Value("${jwt.util.chrono.unit.number:X}")
	private int unitsNumber;

	private Key key;

	@PostConstruct
	public void init() {
		byte[] secretKeyDecoded = Base64.getDecoder().decode(this.encodedSecretKey.getBytes());
		this.key = new SecretKeySpec(secretKeyDecoded, this.signatureAlgorithm);
	}
	
	
	@Data
	@AllArgsConstructor
	public static class ClientDetails {
		public String email;
		public ClientType clientType;
		public int clentId;
	}
	

	public String generateToken(ClientDetails clientDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("clientType", clientDetails.clientType);
		claims.put("clentId", clientDetails.clentId);
		return createToken(claims, clientDetails.email);
	}

	private String createToken(Map<String, Object> claims, String subject) {
		Instant now = Instant.now();
		return Jwts.builder().setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(this.unitsNumber, ChronoUnit.valueOf(this.chronoUnit))))
				.signWith(this.key)
				.compact();
	}

	public ClientDetails extractClient(String token) throws CouponSystemException {
		Claims claims = extractAllClaims(token);
		String email = claims.getSubject();
		ClientType clientType = ClientType.valueOf(claims.get("clientType", String.class));
		int clientId = claims.get("clentId", Integer.class);
		return new ClientDetails(email, clientType, clientId);
	}

	private Claims extractAllClaims(String token) throws CouponSystemException {
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(this.key).build();
		try {
			return jwtParser.parseClaimsJws(token).getBody();			
		}catch(ExpiredJwtException e) {
			throw new CouponSystemException("extractAllClaims failed - the Claims has an expiration time");
		}
	}

	/** returns the JWT subject - in our case the email address 
	 * @throws CouponSystemException */
	public String extractSubject(String token) throws CouponSystemException {
		return extractAllClaims(token).getSubject();
	}

	public Date extractExpiration(String token) throws CouponSystemException {
		return extractAllClaims(token).getExpiration();
	}

	public Date extractIssuedAt(String token) throws CouponSystemException {
		return extractAllClaims(token).getIssuedAt();
	}

	public boolean isTokenValid(String token) {
		try {
			extractAllClaims(token);
			return true;
		} catch (CouponSystemException e) {
			return false;
		}
	}

}
