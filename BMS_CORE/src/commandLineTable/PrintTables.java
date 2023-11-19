package commandLineTable;

import java.util.ArrayList;

import models.BMSLoginInfo;
import models.BillsData;
import models.GSTDetails;
import models.ScanSignupData;
import models.SpecificBillsDetails;
import models.WorkerDetails;

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
		table.setHeaders("Sr. No.", "User Name", "Employee Mail ID", "Bsiness Name", "Role");
		for(BMSLoginInfo info : loginInfo){
			table.addRow(Integer.toString(++i), info.getClientName(), info.getMailId(), info.getBusinessName(), info.getRole());
		}
		table.print();
	}
	
	public static void printWorkerData(ArrayList<WorkerDetails> workerdata){
			int i = 0;
			CommandLineTable table = new CommandLineTable();
			table.setShowVerticalLines(true);
			table.setHeaders("Sr. No.", "Client Name", "Mail Id", "Business Name", "Role");
			for(WorkerDetails data : workerdata){
				table.addRow(Integer.toString(++i), data.getClientName(), data.getMailId(), data.getBusinessName(), data.getRole());
			}
			table.print();
	}

	public static void printBillsList(ArrayList<BillsData> billsData) {
		CommandLineTable table = new CommandLineTable();
		table.setShowVerticalLines(true);
		table.setHeaders("Bill ID", "Customer Name", "Contact Numer", "Customer's Address", "Date of Bill", "Total Amount", "Discount Availed");
		for(BillsData data : billsData){
			table.addRow(data.getBillId(), data.getCustomerName(), data.getPhoneNumer(), data.getAddress()
					, data.getBillDate(), data.getTotalAmount(), (data.getDiscount() != null) ?  data.getDiscount() : "0");
		}
		table.print();
	}

	public static void printCompleteBill(ArrayList<SpecificBillsDetails> billData) {
		if(billData != null && !billData.isEmpty()){
			CommandLineTable table = new CommandLineTable();
			table.setShowVerticalLines(true);
			table.setHeaders("", "Pheonix Business", "Noida", "");
			table.addRow("Bill Id", billData.get(0).getBillId(), "Name", billData.get(1).getCustomerName());
			table.addRow("Bill Date", billData.get(0).getBillId(), "Email", billData.get(1).getEmail());
			table.addRow("","", "Contact", billData.get(1).getPhoneNumber());
			table.addRow("", "", "Address", billData.get(1).getAddress());
			table.addRow("----------", "----------", "----------", "--------------------");
			double totalAmount = 0;
			table.addRow("ProductName","Per Unit Price", "Quantity", "Total Price (With 5% GST)");
			
			for(SpecificBillsDetails data : billData){
				table.addRow(data.getProductName(),Double.toString(data.getProductUnitPrice()), Integer.toString(data.getQuantity()), Double.toString(data.getTotalPrice()));
				totalAmount += data.getTotalPrice();
			}
			table.addRow("----------", "----------", "----------", "----------");
			table.addRow("", "", "Total Amount", Double.toString(totalAmount));
			table.print();
		}else{
			System.out.println("No Information found for this Bill.");
		}
	}

	public static void printGSTDetails(ArrayList<GSTDetails> gstInfo) {

		if(gstInfo != null && !gstInfo.isEmpty()){
			CommandLineTable table = new CommandLineTable();
			table.setShowVerticalLines(true);
			double totalTurnOver = 0;
			double totalGST = 0;
			table.setHeaders("", "", "", "Total Bills Summary", "", "");
			table.addRow("Bill Number", "Product Name", "Quantity", "Per Unit Price", "Total Price", "GST");
			for(GSTDetails data : gstInfo){
				table.addRow(Integer.toString(data.getBillId()),data.getProductName(), Integer.toString(data.getQuantity()),Double.toString(data.getUnitPrice()),  Double.toString(data.getTotalPrice()), Double.toString(data.getGst()));
				totalTurnOver += data.getTotalPrice();
				totalGST += data.getGst();
			}
			table.print();
			printGSTandTurnOverTable(totalTurnOver, totalGST, gstInfo.get(0).getBillDate(), gstInfo.get(gstInfo.size()-1).getBillDate());
		}else{
			System.out.println("No Information found for any Bill or GST.");
		}
		
	}
	
	public static void printGSTandTurnOverTable(double totalTurnOver, double totalGST, String startDate, String endDate){
		System.out.println("Details of Gst and Total TurnOver are as follows: ");
		CommandLineTable table = new CommandLineTable();
		table.setShowVerticalLines(true);
		table.setHeaders("Start Date", startDate);
		table.addRow("End Date", endDate);
		table.addRow("Total GST", Double.toString(totalGST));
		table.addRow("Total TurnOver", Double.toString(totalTurnOver));
		table.print();
	}
}
