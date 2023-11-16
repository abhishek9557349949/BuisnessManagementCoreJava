package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import commandLineTable.PrintTables;
import constants.BMSConstants;
import constants.RoleBasedEnums;
import dao.UserChoiceDao;
import models.BMSLoginInfo;
import models.ScanSignupData;

public class UserChoiceServices {
	
	public static boolean userSelectedChoice(String userChoice, String UserRole) throws SQLException, InterruptedException{
		
		if(UserRole.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.BACK.getId()) 
    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.BACK.getKey())){
				return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GRANT_ACCESS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GRANT_ACCESS.getKey())){
				UserChoiceDao.getAndApprovePendingRequest(BMSConstants.loginInfo.getBusinessName());
				System.out.println("Enter the name of the employee to approve his request or press 0 to back");
				Scanner sc=new Scanner(System.in);
		    	String approverequest = sc.nextLine();
		    	if(!approverequest.equalsIgnoreCase("0")){
		    		UserChoiceDao.approveRequestByName(approverequest);
		    	}
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.ORDER_ITEMS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.ORDER_ITEMS.getKey())){
				UserChoiceDao.checkInventory();
				System.out.println("You Will be redirected to main page in 5 secs.");
				Thread.sleep(4000);
				return false;
			}
		}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.BACK.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.BACK.getKey())){
					return true;
			}
		}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.BACK.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.BACK.getKey())){
					return true;
				}
		
		}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.BACK.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.BACK.getKey())){
					return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.ORDER_ITEMS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.ORDER_ITEMS.getKey())){
				UserChoiceDao.checkInventory();
				System.out.println("You Will be redirected to main page in 5 secs.");
				Thread.sleep(4000);
				return false;
			}
		}
		
		return true;
	}

}
