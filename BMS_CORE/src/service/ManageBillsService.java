package service;

 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import commandLineTable.PrintTables;
import constants.DisplayStrings;
import dao.ManageBillsDao;
import exceptions.DatabaseExceptions;
import exceptions.ServiceBasedExceptions;
import models.BillsData;
import models.GSTDetails;
import models.SpecificBillsDetails;

public class ManageBillsService {
	
	static Scanner sc = new Scanner(System.in);

	public static void getAllBillsData() throws SQLException, ServiceBasedExceptions {
		try{
			ArrayList<BillsData> billsData = ManageBillsDao.getAllBillsDataFromDb();
			PrintTables.printBillsList(billsData);
			System.out.println(DisplayStrings.SPECIFIC_BILL_INFO_INPUT_MESSAGE);
			int specificBillInfo = sc.nextInt();
			ArrayList<SpecificBillsDetails> data = ManageBillsDao.getSpecificBillInfo(specificBillInfo);
			PrintTables.printCompleteBill(data);
		}catch (Exception e) {
            throw new ServiceBasedExceptions("Error in providing service for all bills data", e);
        }
		
	}

	public static void getGSTInfo() throws SQLException, ServiceBasedExceptions {
		try{
			System.out.println("For Food items the total GST is 5 % of the total amount of the product");
			ArrayList<GSTDetails> gstInfo = ManageBillsDao.getGSTAndTotalTurnoverDetails();
			PrintTables.printGSTDetails(gstInfo);
		}catch (Exception e) {
            throw new ServiceBasedExceptions("Error in providing service for all bills data", e);
        }
	}


}
