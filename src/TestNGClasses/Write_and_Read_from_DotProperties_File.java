package TestNGClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import GenericClasses.Excel_Transactions;

public class Write_and_Read_from_DotProperties_File 
{
@Test
public void WriteDataInto_DotPropertiesFile() throws IOException
{
Excel_Transactions.InsertdataInPropertiesFile("driver", "com.mysql.jdbc.Driver", "constring", "jdbc:mysql://localhost:3305/sample", "url", "http://localhost:9090/login.do", "un", "admin", "pw", "manager", "sql", "use sample", "sql2", "select slno from master");
}

@Test(dependsOnMethods = "WriteDataInto_DotPropertiesFile")
public void ReadDataFrom_DotPropertiesFile() throws FileNotFoundException
{
	Excel_Transactions.read_propertiesfile("url", "un","pw","sql2","constring","driver","sql" );
	Reporter.log("reading values based on keys provided", true);
}
}
