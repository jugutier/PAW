package ar.edu.itba.it.paw.model;

import java.util.HashMap;
import java.util.Map;

public class CredentialsManager {
	private static CredentialsManager cm;
	Map<String,String> userPass = new HashMap<String,String>();
	private CredentialsManager() {
		userPass.put("test", "test");
	}

	public static CredentialsManager getInstance() {
		if (cm == null) {
			cm = new CredentialsManager();
		}
		return cm;
	}
	public boolean isValid(String username,String password){
		if(username ==null || password == null){
			return false;
		}
		String dbPassword= userPass.get(username);
		if(dbPassword == null){
			return false;
		}
		return dbPassword.equals(password);
	}
}
