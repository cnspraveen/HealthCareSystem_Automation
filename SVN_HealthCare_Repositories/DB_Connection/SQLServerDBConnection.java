package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.*;

public class SQLServerDBConnection
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String ConString = "jdbc:sqlserver://localhost:1433\\MSSQLSERVER;databaseName=sampleone;integratedSecurity=false";
		
		System.out.println("Connected!!");
		//String user = "CODE1\310076288";
		//String pwd = "";
		Connection c= DriverManager.getConnection(ConString, "","");
		ResultSet rs = c.createStatement().executeQuery("select * from sampletab");
		System.out.println(rs);
		c.close();	
	/*	Class.forName("com.mysql.jdbc.Driver");
		String ConString = "jdbc:mysql://localhost:3305/sample"; */

	}

}
