package ideajoy.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager implements AuthenticationService, AuthenticationStore
	{
	  static Map<String, String> mMap; 
	 Sha256Imp sha = new Sha256Imp();
	 public AuthenticationManager()
	 {
		 mMap = new HashMap<String, String>();
	 }

	@Override
	public void createUser(String userId, String password) {
		// TODO Auto-generated method stub
		mMap.put(userId, sha.hashPassPhrase(userId, password));
	}

	@Override
	public boolean match(String id, String passphrase) {
		// TODO Auto-generated method stub
		if (mMap.containsKey(id))
		{
			if (mMap.get(id).equals(sha.hashPassPhrase(id, passphrase)))
			{
				return true;
			}
		}
		return false;
	}
		
	}	
