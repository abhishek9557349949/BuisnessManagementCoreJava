package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc_connector.Create_connection;
import models.BMSLoginInfo;
import queries.SQLStrings;

public class UserChoiceDao {

	public static ArrayList<BMSLoginInfo> getAndApprovePendingRequest(String businessName) throws SQLException {
		String pendingRequestQuerry = SQLStrings.getPendingRequest;
		Connection connection = Create_connection.getNewConnection();
        PreparedStatement statement = connection.prepareStatement(pendingRequestQuerry);
        statement.setString(1, businessName);
        ResultSet rs = statement.executeQuery();
        ArrayList<BMSLoginInfo> list = new ArrayList<BMSLoginInfo>();
        while(rs.next()){
        	BMSLoginInfo loginInfo = new BMSLoginInfo();
        	loginInfo.setClientName(rs.getString("CLIENT_NAME"));
        	loginInfo.setMailId(rs.getString("MAIL_ID"));
        	loginInfo.setBusinessName(rs.getString("BUSINESS_NAME"));
        	loginInfo.setRole(rs.getString("ROLE"));
        	list.add(loginInfo);
        }
        statement.close();
        Create_connection.closeConnection(connection);
        return list;
	}

}
