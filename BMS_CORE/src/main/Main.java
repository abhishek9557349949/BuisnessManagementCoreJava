package main;

import java.sql.SQLException;
import java.util.Scanner;


import constants.BMSConstants;
import constants.RoleBasedEnums;
import dao.UserSession;
import service.UserSessionServices;

public class Main {
	    public static void main(String[] args) throws Exception {
	    	boolean isQuit = false;
	    	System.out.println("Welcome to the Pheonix Buisness");
	    	while(!isQuit){
		    	System.out.println("Select What you want to do:");
	    		for(BMSConstants.LoginPage id : BMSConstants.LoginPage.class.getEnumConstants()){
					System.out.println(id.getId() + ". " + id.getKey());
				}
		    	@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
		    	String mainPageInput = sc.nextLine();
		    	isQuit = UserSessionServices.Sessionservices(mainPageInput);
		    }
	}
}
