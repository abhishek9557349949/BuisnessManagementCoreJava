package jdbc_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create_connection {
	
    private static String url = "jdbc:mysql://localhost:3306/hix_bms_data";
    private static String user = "root";
    private static String password = "abhi123";
	
	public static Connection getNewConnection() throws SQLException{
			try{
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection connection = DriverManager.getConnection(url, user, password);
		        return connection;
			}
			catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
			return null;
	}
	
	public static void closeConnection(Connection connection) throws SQLException{
		try{
			if(!connection.isClosed()){
				connection.close();
			}
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
}

}
