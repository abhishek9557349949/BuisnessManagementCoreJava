package service;

import java.sql.SQLException;
import java.util.ArrayList;

import commandLineTable.PrintTables;
import constants.BMSConstants;
import constants.RoleBasedEnums;
import dao.UserChoiceDao;
import models.BMSLoginInfo;
import models.ScanSignupData;

public class UserChoiceServices {
	
	public static boolean userSelectedChoice(String userChoice, String UserRole) throws SQLException{
		
		if(UserRole.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.BACK.getId()) 
    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.BACK.getKey())){
				return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GRANT_ACCESS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GRANT_ACCESS.getKey())){
				ArrayList<BMSLoginInfo> loginInfo = UserChoiceDao.getAndApprovePendingRequest(BMSConstants.loginInfo.getBusinessName());
				PrintTables.printPendingApprovals(loginInfo);
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
				}
		
		}
		
		return true;
	}

}
