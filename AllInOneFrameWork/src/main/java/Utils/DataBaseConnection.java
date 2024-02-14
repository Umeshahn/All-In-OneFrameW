package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

	
	public static Connection makeDBConnection(String dbIPAddress, String dbName, String dbUserName, String dbPassword) {
		
		//composing the URL through which SQL Server connection can be established
		final String strConnectionString = "jdbc:sqlserver://" + dbIPAddress + ";databaseName=" + dbName + ";user=" + dbUserName + ";password=" + dbPassword;
        Log.message("The Connection String is : " + strConnectionString);
        Connection conn = null;
        
        try {
        	//STEP 2: Register JDBC driver
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	
        	//STEP 3: Open a connection
        	 Log.message("Connecting to database: " + dbName);
        	 conn = DriverManager.getConnection(strConnectionString, dbUserName, dbPassword);
        	 Log.message("Connection to the DB:" + dbName + " is successful");
        	 
        	
        }catch(Exception e) {
        	Log.error("The Error while connecting to the "+dbName+" and the error message is "+e.getMessage());
        }
        return conn;
	}
}
