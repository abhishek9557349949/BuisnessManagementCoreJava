package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exceptions.DatabaseExceptions;
import jdbc_connector.Create_connection;
import models.BillsData;
import models.GSTDetails;
import models.SpecificBillsDetails;
import models.WorkerDetails;
import queries.SQLStrings;

public class ManageBillsDao {

	public static ArrayList<BillsData> getAllBillsDataFromDb() throws SQLException, DatabaseExceptions {
		try{
			String getBillsList = SQLStrings.getBillsList;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(getBillsList);
	        ResultSet rs = statement.executeQuery();
	        ArrayList<BillsData> billsData = new ArrayList<BillsData>();
	        while(rs.next()){
	        	BillsData details  = new BillsData();
	        	details.setBillId(rs.getString("BILL_ID"));
	        	details.setCustomerName(rs.getString("CUSTOMER_NAME"));
	        	details.setPhoneNumer(rs.getString("PHONE_NUMBER"));
	        	details.setBillDate(rs.getString("BILL_DATE"));
	        	details.setTotalAmount(rs.getString("TOTAL_AMOUNT"));
	        	details.setDiscount(rs.getString("DISCOUNT"));
	        	details.setAddress(rs.getString("CUSTOMER_ADDRESS"));
	        	billsData.add(details);
	        }
	        statement.close();
	        Create_connection.closeConnection(connection);
	        return billsData;
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error retrieving information of all Bills from the database", e);
        }
	}

	public static ArrayList<SpecificBillsDetails> getSpecificBillInfo(int specificBillInfo) throws SQLException, DatabaseExceptions {
		
		try{
			String getSpecificBillInfo = SQLStrings.getSpecificBillInfo;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(getSpecificBillInfo);
	        statement.setInt(1, specificBillInfo);
	        ResultSet rs = statement.executeQuery();
	        ArrayList<SpecificBillsDetails> specificBillData = new ArrayList<SpecificBillsDetails>();
	        while(rs.next()){
	        	SpecificBillsDetails details  = new SpecificBillsDetails();
	        	details.setBillId(rs.getInt("BILL_ID"));
	        	details.setBillDate(rs.getString("BILL_DATE"));
	        	details.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));
	        	details.setBillDate(rs.getString("DISCOUNT"));
	        	details.setCustomerName(rs.getString("CUSTOMER_NAME"));
	        	details.setEmail(rs.getString("EMAIL"));
	        	details.setPhoneNumber(rs.getString("PHONE_NUMBER"));
	        	details.setAddress(rs.getString("ADDRESS"));
	        	details.setProductName(rs.getString("PRODUCT_NAME"));
	        	details.setProductUnitPrice(rs.getDouble("PRODUCT_UNIT_PRICE"));
	        	details.setQuantity(rs.getInt("QUANTITY"));
	        	details.setTotalPrice(rs.getInt("TOTAL_PRICE"));
	        	specificBillData.add(details);
	        }
	        statement.close();
	        Create_connection.closeConnection(connection);
			return specificBillData;
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error retrieving specific bill information from the database", e);
        }
	}

	public static ArrayList<GSTDetails> getGSTAndTotalTurnoverDetails() throws SQLException, DatabaseExceptions {

		try{
			String gstDetailsQuery = SQLStrings.gstDetails;
			Connection connection = Create_connection.getNewConnection();
	        PreparedStatement statement = connection.prepareStatement(gstDetailsQuery);
	        ResultSet rs = statement.executeQuery();
	        ArrayList<GSTDetails> gstDetailsList = new ArrayList<GSTDetails>();
	        while(rs.next()){
	        	GSTDetails details  = new GSTDetails();
	        	details.setBillId(rs.getInt("BILL_ID"));
	        	details.setBillDate(rs.getString("BILL_DATE"));
	        	details.setProductName(rs.getString("PRODUCT_NAME"));
	        	details.setUnitPrice(rs.getDouble("UNIT_PRICE"));
	        	details.setQuantity(rs.getInt("QUANTITY"));
	        	details.setTotalPrice(rs.getInt("TOTAL_PRICE"));
	        	details.setGst(rs.getDouble("GST"));
	        	gstDetailsList.add(details);
	        }
	        statement.close();
	        Create_connection.closeConnection(connection);
			return gstDetailsList;
		}catch (SQLException e) {
            throw new DatabaseExceptions("Error retrieving GST and Totalturnover information from the database", e);
        }
	}
}
