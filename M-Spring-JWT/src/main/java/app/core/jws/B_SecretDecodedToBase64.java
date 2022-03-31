package app.core.jws;

import java.util.Arrays;
import java.util.Base64;

public class B_SecretDecodedToBase64 {

	public static void main(String[] args) {

		String secretKey = "123456789a123456789a123456789a123456789a123";
		byte[] secretKeyEncoded = secretKey.getBytes();
		System.out.println(Arrays.toString(secretKeyEncoded));
		System.out.println(secretKeyEncoded.length);
		
		//we need an array of bytes in base-64
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKeyEncoded);
		System.out.println(Arrays.toString(secretKeyDecoded));
		System.out.println(secretKeyDecoded.length);
		
	}

}
