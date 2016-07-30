package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Row;

public class ValuesFrom_EachRow_EachColumn 
{	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	 	 Class.forName("com.mysql.jdbc.Driver");
	 	 String ConString = "jdbc:mysql://localhost:3305/sample";
	 	 String un = "rootone";
	 	 String pw = "password";
	 	Connection c = DriverManager.getConnection(ConString, un, pw);
	 	 ResultSet rs = c.createStatement().executeQuery("Select * from slave");
	 	 int cc = rs.getMetaData().getColumnCount();
	 	 System.out.println(cc);
	 	 rs.next();
	 	 for(int i=1;i<=cc;i++)
			 {
			String  sam = rs.getString(i);
			System.out.println(sam);
			 }
	 	
	 	 // This code is reading complete each row one after the another(Ex: First complete row, then 2nd complete row, then thirs complete row).  
	 	 while(rs.next())                                        
	 	 {
	 		 int value = rs.getInt(1);
	 		 System.out.println(value);
	 		 String name = rs.getString("name");
	 		 System.out.println(name);
	 		 String applname =rs.getString("application");
	 		 System.out.println(applname);
	 		 
	 		 System.out.println(value + "  " + name + "  " + applname);
	 	 }

	 	 
	 	 int maxrows = rs.getStatement().getMaxRows();
	 	 System.out.println(maxrows);
	 	 for(int i = 1;i<=maxrows;i++)
		 	 { 
	 		 rs.next();
		 	  System.out.println(rs.getString(i));
		 	 	 for(int j=1;j<=cc;j++)
		 		 {
		 			 //rs.moveToCurrentRow();
		 			 String colName = rs.getMetaData().getColumnName(j);
		 		     System.out.println(rs.getString(j));
		 		 }
		 	 }  
		
		
		/*int r = rs.getRow();
	 	 System.out.println("No of records in resultset" + r); */
		
	 	 
	 	/*boolean rc = rs.last();
	 	int rowcount = 0;*/
	 	
	 	 
	 	 
	 	/*while(rs.next())
	 	{
	 		rowcount++;
	 		for(int j=1;j<=cc;j++)
	 		 {
	 			 //rs.moveToCurrentRow();
	 		System.out.println(rs.getString(j));
	 		 }	
	 	}
	 	System.out.println("There are"  + " " + rowcount + " records");
	 	*/	 	 
	 	c.close();
	 	}
}
