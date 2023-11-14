package queries;

public class SQLStrings {

	public static final String loginString = "SELECT CLIENT_NAME, MAIL_ID, FAILED_LOGIN_ATTEMPTS, ACCOUNT_STATUS, BUSINESS_NAME, ROLE, APPROVED_BY_OWNER " +
            "FROM hix_bms_data.bms_login_data " +
            "WHERE USER_NAME = ? AND PASSWORD_HASHCODE = ?";
	
	public static final String incorrectLogin = "UPDATE hix_bms_data.bms_login_data SET FAILED_LOGIN_ATTEMPTS = FAILED_LOGIN_ATTEMPTS + 1 WHERE USER_NAME = ?;";
}
