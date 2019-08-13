package com.project.MavenProject.exceldata;

public class TC_101 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		String val = e1.getCellData("login", 0, 1);
		System.out.println(val);
		
		
		String val1 = e1.getCellData("login", "Password", 4);
		System.out.println(val1);
		
		
		int count = e1.getRowCount("login");
		System.out.println(count);
		
		
		e1.setCellData("login", 4, 1, "Passed");
	}

}
