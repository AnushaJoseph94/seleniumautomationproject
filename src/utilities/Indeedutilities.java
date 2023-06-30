package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Indeedutilities {
	public static int getRowCount(String xl,String sheet) throws Exception
	{
		FileInputStream f=new FileInputStream(xl);
		XSSFWorkbook wb=new XSSFWorkbook(f);
		return wb.getSheet(sheet).getLastRowNum();
		
		
	}
	public static String getCellValue(String xl,String sheet,int r,int c) throws Exception
	{

		FileInputStream f=new FileInputStream(xl);
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFCell cell=wb.getSheet(sheet).getRow(r).getCell(c);
		return cell.getStringCellValue();
	}



}
