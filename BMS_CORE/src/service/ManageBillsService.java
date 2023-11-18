package service;

 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import commandLineTable.PrintTables;
import constants.DisplayStrings;
import dao.ManageBillsDao;
import models.BillsData;
import models.SpecificBillsDetails;

public class ManageBillsService {
	
	static Scanner sc = new Scanner(System.in);

	public static void getAllBillsData() throws SQLException {
		ArrayList<BillsData> billsData = ManageBillsDao.getAllBillsDataFromDb();
		PrintTables.printBillsList(billsData);
		System.out.println(DisplayStrings.SPECIFIC_BILL_INFO_INPUT_MESSAGE);
		int specificBillInfo = sc.nextInt();
		ArrayList<SpecificBillsDetails> data = ManageBillsDao.getSpecificBillInfo(specificBillInfo);
		PrintTables.printCompleteBill(data);
	}


}
