package ideajoy.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Imp implements Sha256 {

	public Sha256Imp() {}
	
	@Override
	public String rawHash(String stringToHash) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			md.update(stringToHash.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digest = md.digest();
		
		String.format("%064x", new java.math.BigInteger(1, digest));
		String sth = String.format("%064x", new java.math.BigInteger(1, digest));
		
		return sth;
	}
	

	@Override
	public String hashPassPhrase(String userId, String passPhrase) {
		return rawHash(userId+passPhrase+salt);	
	
	}
	
	private String salt;
	
	public Sha256Imp(String instanceSalt) {
		salt = instanceSalt;
		
		// TODO Auto-generated constructor stub
	}

	
	
}
