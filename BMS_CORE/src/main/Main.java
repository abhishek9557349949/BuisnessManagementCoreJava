package main;

import java.util.Scanner;

import constants.BMSConstants;
import constants.DisplayStrings;
import service.UserSessionServices;

public class Main {
	    public static void main(String[] args) throws Exception {
	    	boolean isQuit = false;
	    	System.out.println(DisplayStrings.WELCOME_STRING);
	    	while(!isQuit){
		    	System.out.println(DisplayStrings.LOGIN_PAGE_CHOICE_QUESTION);
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
