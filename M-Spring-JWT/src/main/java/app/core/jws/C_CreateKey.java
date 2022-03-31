package app.core.jws;

import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.SignatureAlgorithm;

public class C_CreateKey {

	public static void main(String[] args) {

		//1.set the secret:
		String secretKey = "123456789a123456789a123456789a123456789a123";
		
		//2.decode to Base-64:
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKey.getBytes());
		
		//3.choose the algorithm:
		String algorithm = SignatureAlgorithm.HS256.getJcaName();
		
		//4.create the key:
		Key key = new SecretKeySpec(secretKeyDecoded, algorithm);
		System.out.println(key.getAlgorithm());
	}

}
