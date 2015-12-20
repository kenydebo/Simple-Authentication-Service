package ideajoy.auth;


import static org.junit.Assert.*;

import org.junit.Test;

public class Sha256Tests {

	@Test
	public void rawHash() {
		String expected = "5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5";
		Sha256 sha256 = createSha256Impl();
		assertEquals(expected, sha256.rawHash("12345"));
	}
	
	@Test
	public void hashVarriesWithUserId(){
		Sha256 sha256 = createSha256Impl();
		assertNotEquals(sha256.hashPassPhrase("bob", "I don't like this song"), sha256.hashPassPhrase("Larry", "I don't like this song"));
	
	}
	
	
	@Test
	public void hashVarriesWithInstanceSalt(){
		Sha256 sha256A = createSha256Impl("instance A");
		Sha256 sha256B = createSha256Impl("Something Different");
		
		assertNotEquals( sha256A.hashPassPhrase("jr.", "12345"), sha256B.hashPassPhrase("jr.", "12345"));
	}
	
	Sha256 createSha256Impl(){
		return createSha256Impl("");
	}
	
	
	Sha256 createSha256Impl(String instanceSalt){
		return new  Sha256Imp(instanceSalt);
		
	//	throw new RuntimeException("Not Yet Implemented");
	}
	
	
	

}
