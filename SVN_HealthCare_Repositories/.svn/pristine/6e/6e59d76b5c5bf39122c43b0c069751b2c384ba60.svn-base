package DB_Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySql_DBConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");  // Loading the DB Driver
		String ConString = "jdbc:mysql://localhost:3305/sample"; //Establish/open the connection
		String Un= "rootone";
		String Pw = "password";
		Connection C = DriverManager.getConnection(ConString, Un, Pw);
		ResultSet rs; // = C.createStatement().executeQuery("use sample"); 
		String sql = "select * from master";
		 rs = C.createStatement().executeQuery(sql); //Execute the SQL Query
		int cc= rs.getMetaData().getColumnCount();
		System.out.println(cc);
		// rs.next();
		for(int i=1; i<=cc; i++)
		{
/*	    System.out.println(rs.getMetaData().getClass());
		    int ColDisplaySize = rs.getMetaData().getColumnDisplaySize(i);
	        System.out.println(ColDisplaySize);
	     	System.out.println(rs.getMetaData().getTableName(i));
	     	System.out.println(rs.getString(i));
	     	System.out.println(rs.getWarnings()); */
		String cn = rs.getMetaData().getColumnName(i);
		System.out.println(cn);
		}
C.close();
	}
}
