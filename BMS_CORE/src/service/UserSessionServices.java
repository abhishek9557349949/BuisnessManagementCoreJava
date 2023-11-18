package service;

import java.util.Scanner;

import constants.BMSConstants;
import constants.DisplayStrings;
import constants.RoleBasedEnums;
import dao.UserSession;

public class UserSessionServices {
	
	public static boolean Sessionservices(String mainPageInput) throws Exception{
		if(mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.LOGIN.getId()) 
    			|| mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.LOGIN.getKey())){
			forLogin();
			return false;
		}else if(mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.SIGNUP.getId()) 
    			|| mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.SIGNUP.getKey())){
    		if(UserSession.signUp()){
    			System.out.println(DisplayStrings.SIGNUP_COMPLETED_MESSAGE);
    		}else{
    			System.out.println(DisplayStrings.SIGHUP_ERROR_MESSAGE);
    		}
    		return false;
    	}else if(mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.QUIT.getId()) 
    			|| mainPageInput.equalsIgnoreCase(BMSConstants.LoginPage.QUIT.getKey())){
    		return true;
    	}else{
    		System.out.println(DisplayStrings.INVALID_OPTION_SELECTED_MESSAGE);
    		for(BMSConstants.LoginPage id : BMSConstants.LoginPage.class.getEnumConstants()){
				System.out.println(id.getId() + ". " + id.getKey());
			}
    		return false;
    	}
		
	}
	
	private static void forLogin() throws Exception{
		boolean isBackNeeded = false;
		boolean isValidLogin = true;
		System.out.println(DisplayStrings.ENTER_USER_AND_PASS_MESSAGE);
    	@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String userName = sc.nextLine();
		String password = sc.nextLine();
		while(isValidLogin && !isBackNeeded){
			isValidLogin = UserSession.getLoginDetails(userName, password);
			if(isValidLogin){
				if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_OWNER_STRING)){
					System.out.println(DisplayStrings.HELLO_STRING + BMSConstants.loginInfo.getClientName());
					System.out.println(DisplayStrings.LOGIN_PAGE_CHOICE_QUESTION);
					for(RoleBasedEnums.BMS_OWNER id : RoleBasedEnums.BMS_OWNER.class.getEnumConstants()){
						System.out.println(id.getId() + ". " + id.getKey());
					}
				}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT_STRING)){
					System.out.println(DisplayStrings.HELLO_STRING + BMSConstants.loginInfo.getClientName());
					System.out.println(DisplayStrings.LOGIN_PAGE_CHOICE_QUESTION);
					for(RoleBasedEnums.BMS_ACCOUNTANT id : RoleBasedEnums.BMS_ACCOUNTANT.class.getEnumConstants()){
						System.out.println(id.getId() + ". " + id.getKey());
					}
				}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE_STRING)){
					System.out.println(DisplayStrings.HELLO_STRING + BMSConstants.loginInfo.getClientName());
					System.out.println(DisplayStrings.LOGIN_PAGE_CHOICE_QUESTION);
					for(RoleBasedEnums.BMS_EXICUTIVE id : RoleBasedEnums.BMS_EXICUTIVE.class.getEnumConstants()){
						System.out.println(id.getId() + ". " + id.getKey());
					}
				}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER_STRING)){
					System.out.println(DisplayStrings.HELLO_STRING + BMSConstants.loginInfo.getClientName());
					System.out.println(DisplayStrings.LOGIN_PAGE_CHOICE_QUESTION);
					for(RoleBasedEnums.BMS_MANAGER id : RoleBasedEnums.BMS_MANAGER.class.getEnumConstants()){
						System.out.println(id.getId() + ". " + id.getKey());
					}
				}
				String userInput = sc.nextLine();
				isBackNeeded = UserChoiceServices.userSelectedChoice(userInput, BMSConstants.loginInfo.getRole());
				if(!isBackNeeded)
					System.out.println(DisplayStrings.ANYTHING_ELSE_MESSAGE);
			}
		}
	}
}
