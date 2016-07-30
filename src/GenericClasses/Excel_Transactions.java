package GenericClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class Excel_Transactions
{
//FileInputStream fis, fis2;
	public static void setCellValue(String xlpath , String sheetname,String[] res) //throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	try{
	   FileInputStream fis = new FileInputStream(xlpath); 
	   Workbook  wb = WorkbookFactory.create(fis);
	   int i=1;
	   for(String v:res)
	   {
		   System.out.println("bhanu"+v);
	    wb.getSheet(sheetname).getRow(i).createCell(7).setCellValue(v);
	    i++;
	   }
	   wb.write(new FileOutputStream(xlpath));
	 }
	catch(Exception e) 
	{
		System.out.println(e);
		System.out.println("Got exception while reading the data from excel");
		
	}
	//return sheetname;
	}
	
////===========================================================================
public static String getCellValue(String xlpath , String sheetname, int rownum, int cellnum) //throws EncryptedDocumentException, InvalidFormatException, IOException
{
try{
   FileInputStream fis = new FileInputStream(xlpath); 
   Workbook  wb = WorkbookFactory.create(fis);
   Sheet sheet = wb.getSheet(sheetname);
   Row row = sheet.getRow(rownum);
   Cell cell = row.getCell(cellnum);
  
   String sv=" ";
   if(cell.getCellType()  == cell.CELL_TYPE_STRING)
   {
    sv = cell.getStringCellValue();
   Reporter.log("String value is : " + sv);
   //return sv;
   }
   else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC)
   {
   double nv = cell.getNumericCellValue();
  Reporter.log("Numeric value is " + nv);
   }
   else if(cell.getCellType() == cell.CELL_TYPE_BOOLEAN)
   {
	  boolean bv = cell.getBooleanCellValue();
	  Reporter.log("Data from Excel is : " + bv);
   } 
   return sv; 
   /*
   String v = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
   Reporter.log("Data from excel : "+v,true);
   return v;
   */
 }
catch(Exception e) 
{
	System.out.println(e);
	System.out.println("Got exception while reading the data from excel");
	return " ";
}
//return sheetname;
}

//===========================================================================
public static int getRowCount(String xlpath1, String login ) throws IOException, EncryptedDocumentException, InvalidFormatException
{
	FileInputStream fis = new FileInputStream(xlpath1);
    Workbook wb = WorkbookFactory.create(fis);
	int totalRow = wb.getSheet(login).getLastRowNum();
	System.out.println("total row is:" + totalRow);
    return totalRow;
}

//===============================================================
public static void InsertdataInPropertiesFile(String key1, String value1,String key2, String value2,String key3, String value3,String key4, String value4,String key5, String value5,String key6, String value6,String key7, String value7) throws IOException
{
	Properties prop = new Properties();
	FileOutputStream fos= new FileOutputStream("./Input_Files/properties/data.properties");
	/*for(int a=1;a<=prop.size();a++)
	{
	prop.setProperty(a,a);  */                    // Ask varun how to put Key Value pair in loop wise
	prop.setProperty(key1,value1);
	prop.setProperty(key2,value2);
	prop.setProperty(key3,value3);
	prop.setProperty(key4,value4);
	prop.setProperty(key5,value5);
	prop.setProperty(key6,value7);
	prop.setProperty(key7,value7);
	prop.store(fos, null);  // save values
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

public static void read_propertiesfile(String key1, String key2,String key3, String key4,String key5, String key6,String key7) throws FileNotFoundException
{
	File file = new File("C:/Praveen/Eclips_Workspace/Healthcare_Automation/Input_Files/properties/data.properties");
	FileInputStream fileinputstream = new FileInputStream(file);
	//Loading properties file
	Properties prop1 = new Properties();
	try{prop1.load(fileinputstream);}
	catch(IOException e)
	{e.printStackTrace();}
	Reporter.log(prop1.getProperty(key1 + " "), true);
	Reporter.log(prop1.getProperty(key2), true);
	Reporter.log(prop1.getProperty(key3), true);
	Reporter.log(prop1.getProperty(key4), true);
	Reporter.log(prop1.getProperty(key5), true);
	Reporter.log(prop1.getProperty(key6), true);
	Reporter.log(prop1.getProperty(key7), true);
	System.out.println("reterving values from properties file based on key value provided");
    WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
	driver.navigate().to( prop1.getProperty(key1));                         //"http://localhost:5050/login.do");
	driver.findElement(By.id("username")).sendKeys(prop1.getProperty(key2));
	driver.findElement(By.name("pwd")).sendKeys(prop1.getProperty(key3));
	Reporter.log("user enter credentails successfully", true);
	driver.findElement(By.partialLinkText("Login")).click();
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("logout link identified & click", true);
	driver.close();
	Reporter.log("User login successfully using parameters from properties file & logout as well", true);
}

public static void csvfilereader(String csvfile) throws IOException
{
	CSVReader csvr = new CSVReader(new FileReader("./Input_Files/csv/CSVInputfile.csv"));   //"./Input_Files/csv/CSVInputfile.csv"));
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



public static String dbConnection(String driver, String Constring, String un, String pw, String sql, String sql2) throws ClassNotFoundException
{
	try{
	Class.forName(driver);
	String ConString;
	Connection c = DriverManager.getConnection(Constring, un, pw);
	ResultSet s = c.createStatement().executeQuery(sql);
	ResultSet s2 =c.createStatement().executeQuery(sql2);
	int cc = s2.getMetaData().getColumnCount();
	System.out.println(cc);
	while(s2.next());
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


public static String ReteriveValuesFromTables(String username, String password, String showdbname, String usedbname, String resultset2, String resultset) throws SQLException,ClassNotFoundException 
{
	Connection con = null;
	try
	{
		Date date2 = new Date();
		SimpleDateFormat sfd2 = new SimpleDateFormat("MM-dd-YYYY HH-mm-ss");
		Class.forName("com.mysql.jdbc.Driver");
		String connString="jdbc:mysql://localhost:3305/sample";
		con = DriverManager.getConnection(connString,username, password);
		int showdb = con.createStatement().executeUpdate(showdbname);
		int usedb = con.createStatement().executeUpdate(usedbname);
		Reporter.log(sfd2.format(date2) + " : " +showdb + "  " + usedb, true);
		ResultSet rs2 = con.createStatement().executeQuery(resultset2);
		int ColumnCount2 = rs2.getMetaData().getColumnCount();		
		System.out.println(ColumnCount2);
			  for( int m =1;m<=ColumnCount2;m++)
			 {
				 String cn = rs2.getMetaData().getColumnName(m);
				  System.out.print(cn + " " + "\t");
			 }
			  System.out.println();
		while(rs2.next())
		{
				System.out.print(rs2.getInt(1));
				System.out.print("\t ");
				System.out.print(rs2.getString(2));
				System.out.print("\t ");
				System.out.print(rs2.getString(3));
				System.out.print("\t ");
				System.out.print(rs2.getInt(4));
				System.out.print("\t ");
				System.out.print(rs2.getString(5));
				System.out.print("\t ");
				System.out.print(rs2.getInt(6));
				System.out.println();
       }
		
		Reporter.log("==================================================", true);
		ResultSet rs = con.createStatement().executeQuery(resultset);
		int ColumnCount3 =rs.getMetaData().getColumnCount();
		for(int q=1;q<ColumnCount3;q++)
		{
			String cn3 = rs.getMetaData().getColumnName(q);
			System.out.print(cn3  + "  " +"\t");
		}
	System.out.println();
		while(rs.next())
		{
			System.out.print(rs.getInt(1));
			System.out.print("\t");
			System.out.print(rs.getString(2));
			System.out.print("\t");
			System.out.print(rs.getString(3));
			System.out.print("\t");
			System.out.print(rs.getInt(4));
			System.out.print("\t");
			System.out.print(rs.getString(5));
			System.out.print("\t");
			System.out.print(rs.getInt(6));
			System.out.println();
		}
		Reporter.log("============================================");
		
//Even if you try to  get ColumnCount, Column Name & Table data 2nd for same result set, You an get the column count & column name but not table data 
//2nd time onwords,  it will not retrieve b'coz result set  from 2nd time onwords, it will get empty, So it doesn't dsiplay any data	
	 /*   int ColumnCount = rs.getMetaData().getColumnCount();
		System.out.println(ColumnCount);
		 for( int O =1;O<=ColumnCount;O++)
		 {
			 String cn = rs.getMetaData().getColumnName(O);
			 System.out.print(cn + "      "  + "\t");          //....  \n -> New Line   \t- New Tab                                //System.out.println(cn + " ");
		 }
		 System.out.println();
//		
		 while(rs.next())
		{
			 System.out.print(rs.getInt(1));
			 System.out.print("\t");
			 System.out.print(rs.getString(2));
			 System.out.println(); 
//			for(int k =1;k<=ColumnCount;k++)
//			{
////			 String tblname= rs.getMetaData().getTableName(k);
////			 Reporter.log(tblname, true);	
//		     System.out.print(rs.getString(k) + "             ");
//	    	}
//			System.out.println();
//			//Reporter.log("\t", true);  // to 			 
	} */
	}
catch(Exception e)
{
	System.out.println(e);
    Reporter.log("Exception handled!!!!!", true);
}
	
finally{con.close();
	if(con.isClosed())
	{Reporter.log("Mysql successful used & connection closed", true);}
	return resultset;
}
	}


public static void dataInsert(String username1, String password1, String usedb2, String insertrow1) throws ClassNotFoundException, SQLException
{
	Date date3 = new Date();
	SimpleDateFormat sfd3 = new SimpleDateFormat("MM-dd-YYYY HH-mm-ss");
	Class.forName("com.mysql.jdbc.Driver"); //Load the driver
	String ConStr = "jdbc:mysql://localhost:3305/sample"; //Establish the connection
	Connection con1 = DriverManager.getConnection(ConStr,username1, password1);
	int usedb = con1.createStatement().executeUpdate(usedb2);
	Reporter.log(sfd3.format(date3) + " : " +"  " + usedb, true);
	
	int insertrow = con1.createStatement().executeUpdate(insertrow1);
	System.out.println(sfd3.format(date3) + " : " + insertrow);
	con1.close();
	if(con1.isClosed())
	{Reporter.log("Mysql successful used for inserting row & connection closed", true);}
}


public static void NavigateToAnyRow(String username2, String password2, String resultset2) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.jdbc.Driver");
	String conString2 = "jdbc:mysql://localhost:3305/sample";
	Connection con2 = DriverManager.getConnection(conString2, username2, password2);
	ResultSet rs2 = con2.createStatement().executeQuery(resultset2);
	System.out.println(rs2.first());   // reterive 1st row values
	   System.out.println(rs2.getString(2));
	   System.out.println(rs2.getInt(1));
	
	System.out.println(rs2.next());  // reterive 2nd row values
	   System.out.println(rs2.getString(2));
	   System.out.println(rs2.getInt(1));
	   
	System.out.println(rs2.previous()); //// again reterive 1st row values
	   System.out.println(rs2.getString(2));
	   System.out.println(rs2.getInt(1));
	   
	System.out.println(rs2.relative(2));  //// reterive to next 2 rows from current row(navigating to 3rd row to reterive values)  
	   System.out.println(rs2.getString(2));
	   System.out.println(rs2.getInt(1));
	   
	System.out.println(rs2.absolute(5));  // navigate to directly to 5th row & reterive values
	   System.out.println(rs2.getString(2));
	   System.out.println(rs2.getInt(1));
	   
	System.out.println(rs2.last());  // Navigate to last row
	   System.out.println(rs2.getString(2));
	   System.out.println(rs2.getInt(1));
	   con2.close();
	   if(con2.isClosed())
		{Reporter.log("Mysql successful used to reterive data from any row randomly & connection closed", true);}
}

//=======================================================================

/*public static void StoreResultsIntoExcel(String xlpath2, String sheetname2, int rownum2) throws EncryptedDocumentException, InvalidFormatException, IOException
{
	FileInputStream fis2 = new FileInputStream(xlpath2); 
	   Workbook  wb2 = WorkbookFactory.create(fis2);
	   Sheet sheet2 = wb2.getSheet(sheetname2);
	   int rowcount2 = sheet2.getLastRowNum();
	   //int cellcount2 = sheet2.getRow(rownum2).getLastCellNum();
	  // Row row2 = sheet2.getRow(rownum2);
	   //Cell cell2 = row2.getCell(cellnum2);
	   for(int i=1;i<=rowcount2;i++)
	   {   
		/* if(sheet2.getRow(i).get)  
		 {
		   sheet2.getRow(i).getCell(9).setCellValue("pass");
	      }
	   else
	   {
		   sheet2.getRow(i).getCell(9).setCellValue("fail");
	   }*/
		  /* for(int j=0;j<cellcount2;j++)
		   {
		    sheet2.getRow(i).getCell(i).setCellValue("");
		   }
	   }
} */


//OR

/*public static void setCellValue(String xlpath2,String sheet,int r,int c,String v)
{
	try{Workbook wb = WorkbookFactory.create(new FileInputStream(xlpath2));
	       Row r1 = wb.getSheet(sheet).getRow(r);
	       if(r1==null){
	        	wb.getSheet(sheet).createRow(r);
	        	System.out.println("Created Row");}   //join query, normalization
	       else{System.out.println("Row already exist");}
	       r1.createCell(c).setCellValue(v);
	       wb.write(new FileOutputStream(xlpath2));
    	}
	   catch(Exception e){e.printStackTrace();};
}
*/
//=====================================================
/*
static WebDriver driver = new FirefoxDriver();
public static void Time_track_header()
{
	driver.findElement(By.xpath("//div[text() = 'Time-Track']"));
}
public static void Tasks_header()
{
	driver.findElement(By.xpath("//div[text() = 'Tasks']"));
}
public static void Reports_header()
{
	driver.findElement(By.xpath("//div[text() = 'Reports']"));
}
public static void Users_header()
{
	driver.findElement(By.xpath("//div[text() = 'Users']"));
}
public static void Work_Schedule_header()
{
	driver.findElement(By.xpath("//div[text() = 'Work Schedule']"));
}
public static void Notifications_header()
{
	driver.findElement(By.xpath("//div[text() = 'Notifications']"));
} */


//Verify Broken links code
/*public static void VerifyBrokenLinks(String urlString) throws IOException
{
	URL url = new URL(urlString);
	HttpURLConnection urlconnection=(HttpURLConnection) url.openConnection();
	try{
	urlconnection.setConnectTimeout(11000);
	urlconnection.setRequestMethod("GET");
	urlconnection.connect();
	if(urlconnection.getResponseCode()==200)
	{
		Object  content= urlconnection.getContent();
		System.out.println("content is " + content);
		Object content_type = urlconnection.getContentType();
		System.out.println("content type is " +content_type);
		long date = urlconnection.getDate();
		System.out.println("date is " +date);
		String msg = urlconnection.getResponseMessage();
		Reporter.log(msg, true);
		Boolean state = urlconnection.getAllowUserInteraction();
		System.out.println(state);
		Boolean defaultCaches = urlconnection.getDefaultUseCaches();
		System.out.println("defaultCache" + defaultCaches);
		URL appurl = urlconnection.getURL();
		System.out.println("Url is " + appurl);
		urlconnection.disconnect();
	}
	else if(urlconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
	{
		System.out.println("link_url" + urlconnection.getResponseMessage() + HttpURLConnection.HTTP_NOT_FOUND);
	}
}
	catch(Exception e)
	{
	   	System.out.println(urlconnection.getErrorStream());
	}
}

OR

public static boolean getResponseCode(String RPString) throws IOException
{
// URL u = new URL(RPString);
//HttpURLConnection httpurlconn = (HttpURLConnection) u.openConnection();
//URLConnection urlc = null;
//	urlc.setDoOutput(true);
  httpurlconn.setConnectTimeout(55000);  //set time
  httpurlconn.setRequestMethod("GET"); //send request
  httpurlconn.connect(); //connect it
  if(httpurlconn.getResponseCode() == 200)
  {
  	long date = httpurlconn.getDate();
  	System.out.println(date);
      Object content = httpurlconn.getContent();
  	System.out.println(content);
  	Object useCaches = httpurlconn.getDefaultUseCaches();
  	System.out.println(useCaches);
  	//int contentlength = httpurlconn.getContentLength();
  	//for(int j=0;j<=contentlength;j++)
  	//{   	} 
  	String msg= httpurlconn.getResponseMessage();
  	Reporter.log("Msg is: " + msg);
  	
  	int connTimeOut = httpurlconn.getConnectTimeout();
  	System.out.println("conn time out is : " +connTimeOut);
  	
  	InputStream inputStream = httpurlconn.getInputStream();
  	System.out.println(inputStream);
  	
  	OutputStream outputStream = httpurlconn.getOutputStream();
  	System.out.println(outputStream);
  	
  	String  getRequestMethod = httpurlconn.getRequestMethod();
  	System.out.println("Request method is : " +getRequestMethod);
  	}
	return true; */
  }


