package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import commandLineTable.PrintTables;
import constants.BMSConstants;
import constants.DisplayStrings;
import constants.RoleBasedEnums;
import dao.UserChoiceDao;
import models.BMSLoginInfo;
import models.ScanSignupData;
import models.WorkerDetails;

public class UserChoiceServices {
	
	public static boolean userSelectedChoice(String userChoice, String UserRole) throws SQLException, InterruptedException{
		

		Scanner sc=new Scanner(System.in);
		
		if(UserRole.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.BACK.getId()) 
    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.BACK.getKey())){
				return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GRANT_ACCESS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GRANT_ACCESS.getKey())){
				UserChoiceDao.getAndApprovePendingRequest(BMSConstants.loginInfo.getBusinessName());
				System.out.println(DisplayStrings.EMPLOYEE_APPROVAL_QUESTION);
		    	String approverequest = sc.nextLine();
		    	if(!approverequest.equalsIgnoreCase("0")){
		    		UserChoiceDao.approveRequestByName(approverequest);
		    	}
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.ORDER_ITEMS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.ORDER_ITEMS.getKey())){
				UserChoiceDao.checkInventory();
				System.out.println(DisplayStrings.ITEM_TO_BE_ORDERS_MESSAGE);
				String orderItem = sc.nextLine();
				Thread.sleep(1000);
				System.out.println(DisplayStrings.ITEM_ORDER_SUCCESS_MESSAGE);
				Thread.sleep(4000);
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_INVENTORY_ITEMS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_INVENTORY_ITEMS.getKey())){
				UserChoiceDao.checkInventory();
				System.out.println(DisplayStrings.REDIRECT_MESSAGE);
				Thread.sleep(4000);
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.REVOKE_ACCESS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.REVOKE_ACCESS.getKey())){
				ArrayList<WorkerDetails> workerdata = UserChoiceDao.checkWorkerList();
				PrintTables.printWorkerData(workerdata);
				System.out.println(DisplayStrings.REVOKE_ACCESS_QUESTION);
				String employeeName = sc.nextLine();
				UserChoiceDao.revokeAccess(employeeName);
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GENRATE_BILLS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.GENRATE_BILLS.getKey())){
				////////////////////////////////////////////////////////////////
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_WORKER_DETAILS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_WORKER_DETAILS.getKey())){
				ArrayList<WorkerDetails> workerdata = UserChoiceDao.checkWorkerList();
				PrintTables.printWorkerData(workerdata);
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_BILLS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_BILLS.getKey())){
				////////////////////////////////////////////////////////////////
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_GST.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_OWNER.CHECK_GST.getKey())){
				////////////////////////////////////////////////////////////////
				return false;
			}else{
				System.out.println(DisplayStrings.INVALID_OPTION_SELECTED_MESSAGE);
			}
			
		}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.BACK.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.BACK.getKey())){
					return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.CHECK_PRODUCT_GST.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.CHECK_PRODUCT_GST.getKey())){
					return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.CHECK_BILLS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_ACCOUNTANT.CHECK_BILLS.getKey())){
					return true;
			}else{
				System.out.println(DisplayStrings.INVALID_OPTION_SELECTED_MESSAGE);
			}
		}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.BACK.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.BACK.getKey())){
					return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.CHECK_BILLS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.CHECK_BILLS.getKey())){
					return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.GENRATE_BILLS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_EXICUTIVE.GENRATE_BILLS.getKey())){
					return true;
			}else{
				System.out.println(DisplayStrings.INVALID_OPTION_SELECTED_MESSAGE);
			}
		}else if(BMSConstants.loginInfo.getRole().equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER_STRING)){
			if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.BACK.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.BACK.getKey())){
					return true;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.CHECK_INVENTORY_ITEMS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.CHECK_INVENTORY_ITEMS.getKey())){
				UserChoiceDao.checkInventory();
				System.out.println(DisplayStrings.REDIRECT_MESSAGE);
				Thread.sleep(4000);
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.GENRATE_BILLS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.GENRATE_BILLS.getKey())){
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.ORDER_ITEMS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.ORDER_ITEMS.getKey())){
				UserChoiceDao.checkInventory();
				System.out.println(DisplayStrings.ITEM_TO_BE_ORDERS_MESSAGE);
				String orderItem = sc.nextLine();
				Thread.sleep(1000);
				System.out.println(DisplayStrings.ITEM_ORDER_SUCCESS_MESSAGE);
				Thread.sleep(4000);
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.CHECK_BILLS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.CHECK_BILLS.getKey())){
				return false;
			}else if(userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.CHECK_WORKER_DETAILS.getId()) 
	    			|| userChoice.equalsIgnoreCase(RoleBasedEnums.BMS_MANAGER.CHECK_WORKER_DETAILS.getKey())){
				ArrayList<WorkerDetails> workerdata = UserChoiceDao.checkWorkerList();
				PrintTables.printWorkerData(workerdata);
				return false;
			}else{
				System.out.println(DisplayStrings.INVALID_OPTION_SELECTED_MESSAGE);
			}
		}
		
		return true;
	}

}
