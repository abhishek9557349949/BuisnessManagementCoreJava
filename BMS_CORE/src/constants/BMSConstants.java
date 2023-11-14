package constants;

import models.LoginData;

public class BMSConstants {
	
	public static final String ACTIVE_ACCOUNT = "Active";
	public static final String YES_STRING = "Y";
	
	public static LoginData loginInfo = null;
	
	public static enum LoginPage {
	    LOGIN("1", "Login"),
	    SIGNUP("2", "SignUp");

	    private final String id;
	    private final String key;

	    LoginPage(String id, String key) {
	        this.id = id;
	        this.key = key;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getKey() {
	        return key;
	    }
	}

}
