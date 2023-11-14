package main;

import java.sql.SQLException;
import java.util.Scanner;


import constants.BMSConstants;
import constants.RoleBasedEnums;
import dao.UserSession;

public class Main {
    public static void main(String[] args) throws SQLException {
    	System.out.println("Welcome to the Pheonix Buisness");
    	System.out.println("Select What you want to do:");
    	System.out.println("1. Login");
    	System.out.println("2. Signup");
    	Scanner sc=new Scanner(System.in);
    	String mainPageInput = sc.nextLine();
    	
    	if(mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.LOGIN.getId()) 
    			|| mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.LOGIN.getKey())){
    		System.out.println("Enter User name followed by your Password: ");
    		String userName = sc.nextLine();
    		String password = sc.nextLine();
    		if(UserSession.getLoginDetails(userName, password)){
    			if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_OWNER)){
    				System.out.println("Hello " + BMSConstants.loginInfo.getClientName());
    				System.out.println("Select what you want to do?");
    				for(RoleBasedEnums.BMS_OWNER id : RoleBasedEnums.BMS_OWNER.class.getEnumConstants()){
    					System.out.println(id.getId() + ". " + id.getKey());
    				}
    			}
    		}
    		
    	}else if(mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.SIGNUP.getId()) 
    			|| mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.SIGNUP.getKey())){
    		
    		System.out.println(BMSConstants.LoginPage.LOGIN.getKey());
    		System.out.println(BMSConstants.LoginPage.LOGIN.getId());
    	}

            // Execute the query
            
//            CommandLineTable table = new CommandLineTable();
//            table.setShowVerticalLines(true);
//            table.print();
             
    }
}
