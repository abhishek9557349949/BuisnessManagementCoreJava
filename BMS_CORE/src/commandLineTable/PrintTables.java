package commandLineTable;

import java.util.ArrayList;

import models.BMSLoginInfo;
import models.ScanSignupData;

public class PrintTables {
	
	public static void printSignupDetails(){
		int i = 0;
	  CommandLineTable table = new CommandLineTable();
      table.setShowVerticalLines(true);
      table.setHeaders("Sr. No.", "Data", "Details");
      table.addRow(Integer.toString(++i), "Your Name", ScanSignupData.getClientName());
      table.addRow(Integer.toString(++i), "Your Mail ID", ScanSignupData.getMailId());
      table.addRow(Integer.toString(++i), "Business Name", ScanSignupData.getBusinessName());
      table.addRow(Integer.toString(++i), "Business Role", ScanSignupData.getRole());
      table.addRow(Integer.toString(++i), "User Name", ScanSignupData.getUserName());
      table.addRow(Integer.toString(++i), "Password", "*****");
      table.print();
	}
	
	public static void printPendingApprovals(ArrayList<BMSLoginInfo> loginInfo){
		int i = 0;
		CommandLineTable table = new CommandLineTable();
		table.setShowVerticalLines(true);
		table.setHeaders("Sr. No.", "Employee Name", "Employee Mail ID", "Bsiness Name", "Role");
		for(BMSLoginInfo info : loginInfo){
			table.addRow(Integer.toString(++i), info.getClientName(), info.getMailId(), info.getBusinessName(), info.getRole());
		}
		table.print();
	}
}
