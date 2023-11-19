package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commandLineTable.CommandLineTable;
import constants.DisplayStrings;
import exceptions.DatabaseExceptions;
import jdbc_connector.Create_connection;
import models.BMSLoginInfo;
import models.WorkerDetails;
import queries.SQLStrings;

public class UserChoiceDao {

	public static void getAndApprovePendingRequest(String businessName) throws SQLException, DatabaseExceptions {
		try{
			String pendingRequestQuerry = SQLStrings.getPendingRequest;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(pendingRequestQuerry);
	        statement.setString(1, businessName);
	        ResultSet rs = statement.executeQuery();
	        int i = 0;
	        CommandLineTable table = new CommandLineTable();
			table.setShowVerticalLines(true);
			table.setHeaders("Sr. No.", "Employee Name", "Employee Mail ID", "Bsiness Name", "Role");
	        while(rs.next()){
	        	table.addRow(Integer.toString(++i), rs.getString("CLIENT_NAME"),rs.getString("MAIL_ID"),  rs.getString("BUSINESS_NAME"), rs.getString("ROLE"));
	        }
	        table.print();
	        statement.close();
	        Create_connection.closeConnection(connection);
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error retrieving information for pending request from the database", e);
        }
	}
	
	public static void approveRequestByName(String name) throws SQLException, DatabaseExceptions {
		try{
			String approvePendingRequest = SQLStrings.approvePendingRequest;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(approvePendingRequest);
	        statement.setString(1, name);
	        statement.executeUpdate();
	        System.out.println("The request has been approved.");
	        statement.close();
	        Create_connection.closeConnection(connection);
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error in updating info for approving request the database", e);
        }
	}

	public static void checkInventory() throws SQLException, DatabaseExceptions {
		try{
			String getProductDetails = SQLStrings.getProductDetails;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(getProductDetails);
	        ResultSet rs = statement.executeQuery();
	        int i = 0;
	        CommandLineTable table = new CommandLineTable();
			table.setShowVerticalLines(true);
			table.setHeaders("Sr. No.", "Product Name", "Price", "Stock Left", "Expiry Date", "Current Discount", "Status");
	        while(rs.next()){
	        	table.addRow(Integer.toString(++i), rs.getString("PRODUCT_NAME"),rs.getString("UNIT_PRICE"),  rs.getString("STOCK_QUANTITY"), rs.getString("EXPIRATION_DATE"), rs.getString("DISCOUNT"), rs.getString("order_status"));
	        }
	        table.print();
	        statement.close();
	        Create_connection.closeConnection(connection);
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error retrieving information of our current invetory from the database", e);
        }
	}
	
	public static ArrayList<WorkerDetails> checkWorkerList() throws SQLException, DatabaseExceptions {
		try{
			String getAllWorkerData = SQLStrings.getAllWorkerData;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(getAllWorkerData);
	        ResultSet rs = statement.executeQuery();
	        ArrayList<WorkerDetails> workerdata = new ArrayList<WorkerDetails>();
	        while(rs.next()){
	        	WorkerDetails details  = new WorkerDetails();
	        	details.setClientName(rs.getString("USER_NAME"));
	        	details.setBusinessName(rs.getString("CLIENT_NAME"));
	        	details.setMailId(rs.getString("MAIL_ID"));
	        	details.setBusinessName(rs.getString("BUSINESS_NAME"));
	        	details.setRole(rs.getString("ROLE"));
	        	workerdata.add(details);
	        }
	        statement.close();
	        Create_connection.closeConnection(connection);
	        return workerdata;
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error retrieving information of all Workers from the database", e);
        }
	}
	
	public static void revokeAccess(String name) throws SQLException, DatabaseExceptions {
		try{
			String revokeAccess = SQLStrings.revokeAccess;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(revokeAccess);
	        statement.setString(1, name);
	        statement.executeUpdate();
	        System.out.println(DisplayStrings.REVOKE_SUCCESS_MESSAGE);
	        statement.close();
	        Create_connection.closeConnection(connection);
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error in updating information for revoking access in the database", e);
        }
	}
}
