package models;

import java.util.Scanner;

import commandLineTable.CommandLineTable;
import constants.BMSConstants;
import constants.RoleBasedEnums;
import dao.UserSession;

public class ScanSignupData {
	
	private static String clientName = "Test Name";
    private static String mailId = "test@gmail.com";
    private static int failedLoginAttempts;
    private static String accountStatus;
    private static String businessName = "Test Buisness";
    private static String role =  "M for manager, E for Exicutive, A for accountant";
    private static String approvedByOwner;
    private static String userName = "test_user123";
    private static String password = "StrongPassword@123";
	
	public static void getSignupDetails() throws Exception{
		Scanner sc=new Scanner(System.in);
		
		failedLoginAttempts = 0;
		accountStatus = "Active";
	    approvedByOwner = "N";
		clientName = sc.nextLine();
	    mailId = sc.nextLine();
	    businessName = sc.nextLine();
	    role = sc.nextLine();
	    userName = sc.nextLine();
	    String passwordstring = sc.nextLine();
	    role = (RoleBasedEnums.BMS_ROLES.containsKey(role) ? RoleBasedEnums.BMS_ROLES.get(role) : null);
	    password = CipherEncryptAndDecrypt.encrypt(passwordstring, CipherEncryptAndDecrypt.stringToSecretKey(BMSConstants.ENCRYPTION_KEY));
	    
	}
	
	public static boolean validateSignupDetails(){
		if(clientName.length() <= 3){
			System.out.println("Name must have atleast three characters.");
			return false;
		}
		if(mailId.length() <= 6 || !mailId.contains(".com") || !mailId.contains("@")){
			System.out.println("Mail Id Entered by you is not correct.");
			return false;
		}
		if(!RoleBasedEnums.BMS_ROLES.containsValue(role) || role == null || role.isEmpty()){
			System.out.println("Role for this business entered by you is not correct.");
			return false;
		}
		if(!UserSession.isValidUserName(userName)){
			System.out.println("Username is already present in system, please try again with other username.");
			return false;
		}
		return true;
	}
	
	public static String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public static String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public static int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}
	public static String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public static String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public static String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static String getApprovedByOwner() {
		return approvedByOwner;
	}
	public void setApprovedByOwner(String approvedByOwner) {
		this.approvedByOwner = approvedByOwner;
	}
	public static String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
