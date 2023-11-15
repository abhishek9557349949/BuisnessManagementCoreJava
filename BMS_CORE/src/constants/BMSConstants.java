package constants;

import models.LoginData;

public class BMSConstants {
	
	public static final String ACTIVE_ACCOUNT = "Active";
	public static final String YES_STRING = "Y";
	public static final String ENCRYPTION_KEY = "LILyJw0dOUdV3pc4+kRgsw==";
	public static final String DECRYPTION_KEY = "LILyJw0dOUdV3pc4+kRgsw==";
	
	public static LoginData loginInfo = null;
	
	public static enum LoginPage {
	    LOGIN("1", "Login"),
	    SIGNUP("2", "SignUp"),
	    QUIT("3", "Quit");

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
