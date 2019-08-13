package com.project.MavenProject.exceldata;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderByName 
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = null;
		
		int colNumber=0;
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
				colNumber=i;
		}
		row=sheet.getRow(4);
		cell=row.getCell(colNumber);

		//String passWord=String.valueOf(cell.getStringCellValue());
		String passWord=cell.getStringCellValue();
		System.out.println("value of exel cell is :" + passWord);
		workbook.close();
		fis.close();

	}

}
