package queries;

public class SQLStrings {

	public static final String loginString = "SELECT CLIENT_NAME, MAIL_ID, FAILED_LOGIN_ATTEMPTS, ACCOUNT_STATUS, BUSINESS_NAME, ROLE, APPROVED_BY_OWNER " +
            "FROM hix_bms_data.bms_login_data " +
            "WHERE USER_NAME = ? AND PASSWORD_HASHCODE = ?";
	
	public static final String incorrectLogin = "UPDATE hix_bms_data.bms_login_data SET FAILED_LOGIN_ATTEMPTS = FAILED_LOGIN_ATTEMPTS + 1 WHERE USER_NAME = ?;";
	
	public static final String signupLogin = "INSERT INTO hix_bms_data.bms_login_data (PASSWORD_HASHCODE, USER_NAME, MAIL_ID, CLIENT_NAME, FAILED_LOGIN_ATTEMPTS, ACCOUNT_STATUS, BUSINESS_NAME, ROLE, APPROVED_BY_OWNER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'N');";

	public static final String checkValidUser = "SELECT USER_NAME FROM hix_bms_data.bms_login_data;";

	public static final String getPendingRequest = "SELECT CLIENT_NAME, MAIL_ID, BUSINESS_NAME, CASE WHEN ROLE = 'BMS_OWNER' THEN 'Owner' WHEN ROLE = 'BMS_MANAGER' THEN 'Manager' WHEN ROLE = 'BMS_ACCOUNTANT' THEN 'Accountant' WHEN ROLE = 'BMS_EXECUTIVE' THEN 'Executive' ELSE ROLE END AS ROLE FROM hix_bms_data.bms_login_data WHERE BUSINESS_NAME = ? and APPROVED_BY_OWNER = 'N' and ROLE != 'BMS_OWNER' and ACCOUNT_STATUS = 'Active';";

	public static final String approvePendingRequest = "UPDATE hix_bms_data.bms_login_data SET APPROVED_BY_OWNER = 'Y' WHERE CLIENT_NAME = ?;";

	public static final String getProductDetails = "SELECT PRODUCT_NAME, UNIT_PRICE, STOCK_QUANTITY, EXPIRATION_DATE, DISCOUNT, CASE WHEN STOCK_QUANTITY < 55 THEN 'Buy Now' WHEN STOCK_QUANTITY <= 75 THEN 'Order Soon' ELSE 'Sufficient Amount' END AS order_status FROM hix_bms_data.bms_products;";
	
	public static final String getAllWorkerData = "SELECT USER_NAME, CLIENT_NAME, MAIL_ID, BUSINESS_NAME, CASE WHEN ROLE = 'BMS_OWNER' THEN 'Owner' WHEN ROLE = 'BMS_MANAGER' THEN 'Manager' WHEN ROLE = 'BMS_ACCOUNTANT' THEN 'Accountant' WHEN ROLE = 'BMS_EXICUTIVE' THEN 'Executive' ELSE ROLE END AS ROLE FROM hix_bms_data.bms_login_data where ROLE != 'BMS_OWNER' and ACCOUNT_STATUS = 'Active';";

	public static final String revokeAccess = "UPDATE hix_bms_data.bms_login_data SET ACCOUNT_STATUS = 'Disabled' WHERE USER_NAME = ?;";
}
