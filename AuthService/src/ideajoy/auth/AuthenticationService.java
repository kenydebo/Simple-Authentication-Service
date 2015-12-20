package ideajoy.auth;

public interface AuthenticationService {
	public boolean match(String id, String passphrase);
}
