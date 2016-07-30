package GenericClasses;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExcelTransaction
{
	//@Test
   //public static String GetCellValue(int rownum, int cellnum)
public static void main(String[] args)
    {
		String xlpath = "C:/Praveen/Eclips_Workspace/Healthcare_Automation/Input_Files/Excel/InputData.xlsx"; 
		String sheetname;
    	try
    	{
    	FileInputStream fis = new FileInputStream(xlpath);
    	Workbook wb = WorkbookFactory.create(fis);
    	
    	Sheet s = wb.getSheet("Sheet1");
    	String sn = s.getSheetName();
		Reporter.log(sn);
		System.out.println(sn);
		
    	int rowcount = s.getLastRowNum();
    	System.out.println(rowcount);
    	for(int i=0;i<rowcount; i++)
    	{
    		Row r = s.getRow(i);//getCell(0);
    		//System.out.println(r);
    		 int cellcount = s.getRow(i).getLastCellNum();
    		     for(int j=0;j<cellcount;j++)
    		      {
    		    	  Cell c=s.getRow(i).getCell(j);
    		      
    		    if(c.getCellType() == c.CELL_TYPE_STRING) {
    		    	String sv = c.getStringCellValue();
    		    	Reporter.log(sv);
    		    	System.out.println(sv);}
    		    else if(c.getCellType() == c.CELL_TYPE_NUMERIC){
    		    	double nv = c.getNumericCellValue();
    		    	//Reporter.log(nv);
    		    	System.out.println(nv);}
    		    else if(c.getCellType() == c.CELL_TYPE_BOOLEAN){
    		    	boolean bn = c.getBooleanCellValue();
    		    	//Reporter.log(bn);
    		    	System.out.println(bn);}
    		    else{Reporter.log("it's different data type");
    		    System.out.println("it's different data type");}
    		  }
    	}
    	}
    	catch(Exception e){
    		Reporter.log("Exception Caught!!!!!");}
//	return "ExcelCode";
    }
}
