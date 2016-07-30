package GenericClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class Excel_Transactions
{
	
static FileInputStream fis, fis2;
public static String getCellValue(String xlpath , String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
{
try
{
   fis = new FileInputStream(xlpath); 
   Workbook  wb = WorkbookFactory.create(fis);
   Sheet sheet = wb.getSheet(sheetname);
   Row row = sheet.getRow(rownum);
   Cell cell = row.getCell(cellnum);
   
   if(cell.getCellType()  == cell.CELL_TYPE_STRING)
   {
   String sv = cell.getStringCellValue();
   System.out.println("String value is : " + sv);
   }
   else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC)
   {  
   double nv = cell.getNumericCellValue();
   System.out.println(nv);
   }
 /*  else(cell.getCellType() == cell.CELL_TYPE_BOOLEAN)
   {
	  boolean bv = cell.getBooleanCellValue();
	  System.out.println("Data from Excel is : " + bv);
   } */
   return "";   
 }
catch(Exception e) 
{
	System.out.println("Got exception while reading the data from excel");
	return "";
}
}

public static void StoreResultsIntoExcel(String xlpath2, String sheetname2, int rownum2, int cellnum2) throws EncryptedDocumentException, InvalidFormatException, IOException
{
	 fis2 = new FileInputStream(xlpath2); 
	   Workbook  wb2 = WorkbookFactory.create(fis2);
	   Sheet sheet2 = wb2.getSheet(sheetname2);
	   int rowcount2 = sheet2.getLastRowNum();
	   int cellcount2 = sheet2.getRow(rownum2).getLastCellNum();
	  // Row row2 = sheet2.getRow(rownum2);
	   //Cell cell2 = row2.getCell(cellnum2);
	   for(int i=0;i<rowcount2;i++)
	   {
		   for(int j=0;j<cellcount2;j++)
		   {
		  sheet2.getRow(i).getCell(i).setCellValue("");
		   }
	   }
}

public static int getRowCount(String xlpath1, String login ) throws IOException, EncryptedDocumentException, InvalidFormatException
{
	fis = new FileInputStream(xlpath1);
    Workbook wb = WorkbookFactory.create(fis);
	int totalRow = wb.getSheet(login).getLastRowNum();
	System.out.println("total row is:" + totalRow);
    return totalRow;
}


public static void properties() throws IOException
{
	Properties prop = new Properties();
	FileOutputStream fos= new FileOutputStream("./Input_Files/properties/data.properties");
	prop.setProperty("driver", "com.mysql.jdbc.Driver");
	prop.setProperty("constring", "jdbc:mysql://localhost:3305/sample");
	prop.setProperty("un", "rootone");
	prop.setProperty("pw", "password");
	prop.setProperty("sql", "use sample");
	prop.setProperty("sql2", "select * from master");
	prop.store(fos, null);
	System.out.println(prop);
	
	// use     below code in SuperNG class to call & read the data from    "data.properties" file
	/*properties prop1 = new properties();
	    InputStream stream = new FileInputStream("./Input_Files/properties/data.properties");
	    String driver = prop1.getProperty("driver");
	    String constring = prop1.getProperty("constring");
	    String un = prop1.getProperty("un");
	    String pw = prop1.getProperty("pw");
	    String sql = prop1.getProperty("sql1");
	    String sql2 = prop1.getProperty("sql2");*/
}

public static void csvfilereader(String csvfile) throws IOException
{
	CSVReader csvr = new CSVReader(new FileReader(csvfile));   //"./Input_Files/csv/CSVInputfile.csv"));
	String[] csvelement = csvr.readNext();
	/*boolean data;
	while(data = csvr.readNext() != null)
	{
		for()
		System.out.println(data);
	} */
  	for(int i=0;i<=csvelement.length;i++)
  	{
  		System.out.print(csvelement[i]);
  	}
  	System.out.println("");
}


public static String dbConnection(String driver, String constring, String un, String pw, String sql, String sql2) throws ClassNotFoundException
{
	
	try{
	Class.forName(driver);
	Connection c = DriverManager.getConnection(constring, un, pw);
	ResultSet s = c.createStatement().executeQuery(sql);
	ResultSet s2 =c.createStatement().executeQuery(sql2);
	int cc = s2.getMetaData().getColumnCount();
	System.out.println(cc);
	s2.next();
	for(int i=1;i<=cc;i++)
	{
		System.out.print(s2.getString(i));
	}
	System.out.println();
	c.close();
	}
	catch(SQLException sqle)
	{
	    System.out.println("SQL Type Exception caught!!!!!");	
	}
/*	finally()
	{
		c.close();
	} */ 
	return "";
}

}
