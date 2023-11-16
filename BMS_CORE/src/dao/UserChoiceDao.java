package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commandLineTable.CommandLineTable;
import jdbc_connector.Create_connection;
import models.BMSLoginInfo;
import queries.SQLStrings;

public class UserChoiceDao {

	public static void getAndApprovePendingRequest(String businessName) throws SQLException {
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
	}
	
	public static void approveRequestByName(String name) throws SQLException {
		String approvePendingRequest = SQLStrings.approvePendingRequest;
		Connection connection = Create_connection.getNewConnection();
        PreparedStatement statement = connection.prepareStatement(approvePendingRequest);
        statement.setString(1, name);
        statement.executeUpdate();
        System.out.println("The request has been approved.");
        statement.close();
        Create_connection.closeConnection(connection);
	}

	public static void checkInventory() throws SQLException {
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
	}
}
