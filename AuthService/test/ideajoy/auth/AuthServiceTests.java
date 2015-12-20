package ideajoy.auth;


import static org.junit.Assert.*;


import org.junit.Test;

public class AuthServiceTests {
	
	
	private AuthenticationManager AM = new AuthenticationManager();

	@Test
	public void passwordMatches() {
		AuthenticationStore store = createAuthStore();
		store.createUser("Bob", "I don't like this song");
		
		AuthenticationService service = createAuthService();
		assertTrue(service.match("Bob", "I don't like this song"));
		
	}
	
	
	@Test
	public void passwordMatchesTwoUsers() {
		AuthenticationStore store = createAuthStore();
		store.createUser("Bob", "I don't like this song");
		
		store.createUser("Larry", "Not Easy being so cool");
		
		AuthenticationService service = createAuthService();
		assertTrue(service.match("Bob", "I don't like this song"));

		assertTrue(service.match("Larry", "Not Easy being so cool"));
	}

	@Test
	public void passwordDoesNotMatch() {
		AuthenticationStore store = createAuthStore();
		store.createUser("Bob", "I don't like this song");
		
		AuthenticationService service = createAuthService();
		assertFalse(service.match("Bob", "I like this song"));	
	}
	
	@Test
	public void userIdDoesNotMarch(){
		AuthenticationService service = createAuthService();
		assertFalse(service.match("Larry", "It's not easy being red"));	
	}
	
	
	private AuthenticationService createAuthService() {
		
	//	throw new RuntimeException("NYI");
		return AM;
		
	}

	private AuthenticationStore createAuthStore(){
		return AM;
		//throw new RuntimeException("NYI");
	}

}
