package ideajoy.auth;

public interface AuthenticationStore {
	void createUser(String userId, String password);
}
