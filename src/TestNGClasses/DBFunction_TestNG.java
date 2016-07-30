package TestNGClasses;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;

public class DBFunction_TestNG 
{
 @Test
public void DBConnQuery() throws SQLException, ClassNotFoundException
 {
	Excel_Transactions.ReteriveValuesFromTables("rootone", "password", "show databases", "use sample", "select * from master order by slno","select * from master");
	Reporter.log("=================================================", true);
	Excel_Transactions.dataInsert("rootone", "password","use sample", "insert into master values(1199,'Damaruswamy','Damaruswamy@g.com','595559','kailasa','595559')");
	//Excel_Transactions.NavigateToAnyRow("rootone", "password", "select * from master order by firstname");
 }
}
