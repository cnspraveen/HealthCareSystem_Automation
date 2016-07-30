package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintSpecficValueFrom_FirstRow_SpecficColumn_fromDB 
{
		public static void main(String[] args) throws ClassNotFoundException, SQLException  
		{
		Class.forName("com.mysql.jdbc.Driver");
		String ConString = "jdbc:mysql://localhost:3305/sample";
		String un = "rootone";
		String pw = "password";
		Connection C = DriverManager.getConnection(ConString, un, pw);
        //String query = "Select * from slave";
        ResultSet rs = C.createStatement().executeQuery("Select * from slave");
        int colcount = rs.getMetaData().getColumnCount();
        System.out.println(colcount);
        
     // Reading value only from 1st row  
        rs.next();
        String specficValuefromSpecficRow_specficColumn =  rs.getString(2);   
        System.out.println(specficValuefromSpecficRow_specficColumn);  
        
   // Retrieve all values from table slave one after other but only 1st row(All colums of 1st row). 
        for(int i=1;i<=colcount;i++)
        {
        	String tabledata =rs.getString(i);
        	System.out.println(tabledata);
        }
        C.close();
	}
}
		
		

