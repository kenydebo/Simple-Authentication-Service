package ideajoy.auth;

public interface Sha256 {
	String rawHash(String stringToHash);
	String hashPassPhrase(String userId, String passPhrase);
}
