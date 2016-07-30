package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseDatabase_InsertQuery_deleteQuery_forDeletingSpecfic_Row_from_table 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	   Class.forName("com.mysql.jdbc.Driver");
       String conString = "jdbc:mysql://localhost:3305/sample";
       String un = "rootone";
       String pw = "password";
       Connection conn =DriverManager.getConnection(conString, un, pw);
       int rs1 = conn.createStatement().executeUpdate("show databases");
       System.out.println(rs1);
       int rs2 = conn.createStatement().executeUpdate("use sample");
       System.out.println(rs2);
       int rs3 = conn.createStatement().executeUpdate("insert into slave(id,name,application) values(3, 'angur', 'angur.com')");
       int rs4 = conn.createStatement().executeUpdate("insert into slave(id,name,application) values(6, 'angurs', 'angurs.com')");
       int rs5 = conn.createStatement().executeUpdate("insert into slave(id,name,application) values(7, 'santra', 'santra.com')");
       ResultSet rs9 = conn.createStatement().executeQuery("describe slave");
       System.out.println(rs2  + " " + rs3 + " " + rs4 + " " +rs5 + " " + rs9);
       ResultSet rs6 = conn.createStatement().executeQuery("select * from slave where id  = 1");
       System.out.println(rs6);
       int rs = conn.createStatement().executeUpdate("delete from slave where id =6");
       System.out.print(rs);
       conn.close();
	}
}
