package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Print_Content_OR_Data_fromTable 
{	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{

		Class.forName("com.mysql.jdbc.Driver");
	    String ConString = "jdbc:mysql://localhost:3305/sample";
	    String un = "rootone";
	    String pw = "password";
	    Connection co = DriverManager.getConnection(ConString, un, pw);
	    ResultSet rs = co.createStatement().executeQuery("Select * from master");
	    int cc= rs.getMetaData().getColumnCount();
	    System.out.println(cc);
     while( rs.next())
     {

// This will print only 1st row if we use "rs.next()" without while loop;  
//  If we want to print all rows one after the other, we need to use  "rs,next()" method in "while" loop but  will print each cell value in next line one after the other. 
//doubt is: how to print only one column ?   
    for(int i=1; i<=cc; i++)
	    {
	    	String col = rs.getString(i);
	    	System.out.println(col);
       	
	 System.out.print(col);
	    	// Output:  1neelakantagmail 2rajugmail.c4appleapple.com 5mangomango.com 3angurangur.com 3angurangur.com 3angurangur.com3angurangur.com7santrasantra.com
	    }
	   }   

	 
//if we want to print each row one after the other (  )	    
   ResultSet rs2 = co.createStatement().executeQuery("Select * from master");
	    int cc2= rs2.getMetaData().getColumnCount();
	    System.out.println(cc2);
	    while( rs2.next())
	   {
	     //This will print only 1st row.  
		//  If we want to print all rows one after the other, we need to use  "rs,next()" method in "while" loop
	  	
	    //	if we want to print all rows one after other, then use this below code. 
		 //doubt is: how to print only one column ?   
	    for(int i=1; i<=cc2; i++)
	    {
	    	String col2 = rs2.getString(i);
	    	System.out.print(col2);
	    }
	    System.out.println();
	   }
	  /*  1neelakantagmail
	    2rajugmail.c
	    4appleapple.com
	    5mangomango.com
	    3angurangur.com
	    3angurangur.com
	    3angurangur.com
	    3angurangur.com
	    7santrasantra.com */
	    
	   
	    
	   // OR   (Another Way to Print each row one after the other. 
	    // Print each row values one by one. Once complete printing of 1st row values, it jump'e for 2nd row & print all values of 2nd row one after the other.
	    ResultSet rs3 = co.createStatement().executeQuery("Select * from master");
	    int cc3= rs3.getMetaData().getColumnCount();
	    System.out.println(cc3);
    while(rs3.next())   
{
System.out.println(rs3.getInt("slno"));
System.out.println(rs3.getString("firstname"));
System.out.println(rs3.getString("email"));
}
//	    // Doubt is: how to read row & column using multiple/nested for loop.
co.close();
	}
}
