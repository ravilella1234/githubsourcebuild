package com.project.MavenProject.exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataByCell 
{
	public static final String EXCELFILELOCATION="C:\\Users\\DELL\\Desktop\\sampledata.xlsx";
	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	
	
	public static void loadExcel() throws Exception
	{
		System.out.println("Loading Excel Data......");
		
		file=new File(EXCELFILELOCATION);
		fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet("testreader");
		fis.close();
	}
	
	
	
	//Map<String, Integer> m= new HashMap<String, Integer>();
	
		
	public static Map<String, Map<String,String>> getDataMap() throws Exception
	{
		if(sheet==null)
		{
			loadExcel();
		}
		
		Map<String,Map<String,String>> superMap = new HashMap<String, Map<String,String>>();
		Map<String,String> myMap = new HashMap<String, String>();
		
		for(int i=1;i<sheet.getLastRowNum()+1;i++)
		{
			row=sheet.getRow(i);
			String keyCell = row.getCell(0).getStringCellValue();
			
			int colNum = row.getLastCellNum();
			for(int j=1;j<colNum;j++)
			{
				String value = row.getCell(j).getStringCellValue();
				myMap.put(keyCell, value);
			}
			superMap.put("MasterData", myMap);
		}
		
		return superMap;
	}
	
	
	public static String getValue(String key) throws Exception
	{
		Map<String,String> myVal=getDataMap().get("MasterData");
		String retValue = myVal.get(key);
		return retValue;
		
	}
	
	public static void main(String[] args) throws Exception 
	{
		System.out.println(getValue("TC_001"));
		System.out.println(getValue("TC_004"));
	}
	

}
