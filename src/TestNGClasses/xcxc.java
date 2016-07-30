package TestNGClasses;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xcxc {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		for(int i=0;i<3;i++)
		{
		 Workbook wb=new XSSFWorkbook();
		   wb.createSheet().createRow(i).createCell(0).setCellValue("hgh");
		   FileOutputStream fos = new FileOutputStream("C:\\InputData.xlsx");
		   wb.write(fos);
		   fos.close();
		}
	}

}
