package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constants.BMSConstants;
import jdbc_connector.Create_connection;
import models.LoginData;
import queries.SQLStrings;

public class UserSession {
	
	public static boolean getLoginDetails(String userName, String password) throws SQLException{
		
		String loginquerry = SQLStrings.loginString;
		Connection connection = Create_connection.getNewConnection();
        PreparedStatement statement = connection.prepareStatement(loginquerry);
        statement.setString(1, userName);
        statement.setString(2, password);
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
	        	if(!loginInfo.getAccountStatus().equalsIgnoreCase(BMSConstants.ACTIVE_ACCOUNT)
	        			|| loginInfo.getFailedLoginAttempts() <= 3){
	        		return true;
	        	}
	        	else{
	        		System.out.println("Your account has been dectivated, Please contact to buisness owner to activate your account.");
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
	}
	
	public static Boolean signUp(){
		
		return null;
	}
}
