package dao;

import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.crypto.SecretKey;

import commandLineTable.PrintTables;
import constants.BMSConstants;
import jdbc_connector.Create_connection;
import models.CipherEncryptAndDecrypt;
import models.LoginData;
import models.ScanSignupData;
import queries.SQLStrings;

public class UserSession {
	
	public static boolean getLoginDetails(String userName, String password) throws Exception{
		String loginquerry = SQLStrings.loginString;
		Connection connection = Create_connection.getNewConnection();
        PreparedStatement statement = connection.prepareStatement(loginquerry);
        statement.setString(1, userName);
        statement.setString(2, CipherEncryptAndDecrypt.encrypt(password, CipherEncryptAndDecrypt.stringToSecretKey(BMSConstants.ENCRYPTION_KEY)));
        ResultSet resultSet = statement.executeQuery();
        
        if(resultSet.next()){
        	LoginData loginInfo = new LoginData(
        			resultSet.getString("CLIENT_NAME"),
                    resultSet.getString("MAIL_ID"),
                    resultSet.getInt("FAILED_LOGIN_ATTEMPTS"),
                    resultSet.getString("ACCOUNT_STATUS"),
                    resultSet.getString("BUSINESS_NAME"),
                    resultSet.getString("ROLE"),
                    resultSet.getString("APPROVED_BY_OWNER"));
        	BMSConstants.loginInfo = loginInfo;
        	if(loginInfo.getApprovedByOwner().equalsIgnoreCase(BMSConstants.YES_STRING)){
	        	if(loginInfo.getAccountStatus().equalsIgnoreCase(BMSConstants.ACTIVE_ACCOUNT)
	        			|| loginInfo.getFailedLoginAttempts() < 3){
	        		return true;
	        	}
	        	else{
	        		System.out.println("Your account has been blocked, Please contact to buisness owner to activate your account.");
	        	}
        	}else{
        		System.out.println("Your Request is pending by the owner, Please wait till he approves it.");
        	}
        } else{
        	incorrectLogin(userName);
        	System.out.println("Either User name or Password is incorect, Please Try again");
        }
        resultSet.close();
        statement.close();
        Create_connection.closeConnection(connection);        
		return false;
	}

	public static void incorrectLogin(String userName) throws SQLException{
		String loginquerry = SQLStrings.incorrectLogin;
		Connection connection = Create_connection.getNewConnection();
        PreparedStatement statement = connection.prepareStatement(loginquerry);
        statement.setString(1, userName);
        statement.executeUpdate();
        statement.close();
        Create_connection.closeConnection(connection);
	}
	
	public static Boolean signUp() throws Exception{
		try{
			System.out.println("Enter all details in the same order as shown below");
			PrintTables.printSignupDetails();
			ScanSignupData.getSignupDetails();
			if(ScanSignupData.validateSignupDetails()){
				System.out.println("Here are the details entered by you");
				PrintTables.printSignupDetails();
				String signUpQuery = SQLStrings.signupLogin;
				Connection connection = Create_connection.getNewConnection();
		        PreparedStatement statement = connection.prepareStatement(signUpQuery);
		        statement.setString(1, ScanSignupData.getPassword());
		        statement.setString(2, ScanSignupData.getUserName());
		        statement.setString(3, ScanSignupData.getMailId());
		        statement.setString(4, ScanSignupData.getClientName());
		        statement.setInt(5, ScanSignupData.getFailedLoginAttempts());
		        statement.setString(6, ScanSignupData.getAccountStatus());
		        statement.setString(7, ScanSignupData.getBusinessName());
		        statement.setString(8, ScanSignupData.getRole());
		        statement.executeUpdate();
		        statement.close();
		        Create_connection.closeConnection(connection);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean isValidUserName(String userName){
		String checkValidUser = SQLStrings.checkValidUser;
		Connection connection;
		try {
			connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(checkValidUser);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            if (userName.equals(resultSet.getString("USER_NAME"))) {
	                return false;
	            }
	        }
	        statement.close();
	        Create_connection.closeConnection(connection);
	        return true;
		} catch (SQLException e) {
			System.out.println("There is some error in checking if the username is valid or not, please try again later.");
			return false;
		}
		
	}

	public static void setSignUp(boolean b) {
		// TODO Auto-generated method stub
		System.out.println("");
	}

}
