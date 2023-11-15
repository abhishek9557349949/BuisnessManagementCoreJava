package models;

public class BMSLoginInfo {

	private static String clientName;
    private static String mailId;
    private static int failedLoginAttempts;
    private static String accountStatus;
    private static String businessName;
    private static String role;
    private static String approvedByOwner;
    private static String userName;
    private static String password;
    
    
	public BMSLoginInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		BMSLoginInfo.clientName = clientName;
	}
	public static String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		BMSLoginInfo.mailId = mailId;
	}
	public static int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}
	public static void setFailedLoginAttempts(int failedLoginAttempts) {
		BMSLoginInfo.failedLoginAttempts = failedLoginAttempts;
	}
	public static String getAccountStatus() {
		return accountStatus;
	}
	public static void setAccountStatus(String accountStatus) {
		BMSLoginInfo.accountStatus = accountStatus;
	}
	public static String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		BMSLoginInfo.businessName = businessName;
	}
	public static String getRole() {
		return role;
	}
	public void setRole(String role) {
		BMSLoginInfo.role = role;
	}
	public static String getApprovedByOwner() {
		return approvedByOwner;
	}
	public static void setApprovedByOwner(String approvedByOwner) {
		BMSLoginInfo.approvedByOwner = approvedByOwner;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		BMSLoginInfo.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		BMSLoginInfo.password = password;
	}
    
}
