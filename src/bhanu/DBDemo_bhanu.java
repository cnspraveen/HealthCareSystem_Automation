package bhanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDemo_bhanu {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String connString="jdbc:mysql://localhost:3305/sample";
		Connection con = DriverManager.getConnection(connString,"rootone","password");
		ResultSet t = con.createStatement().executeQuery("select * from master");
		while(t.next())
		{
			for(int i=1;i<=t.getMetaData().getColumnCount();i++)
			{
				System.out.print(t.getString(i));
			}
			System.out.println("-----------------------------------");
		}
		
		con.close();
	}

}
