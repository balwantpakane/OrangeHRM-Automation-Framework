package com.hrms.utilities;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	public static Object[][] getTestData(String filePath, String sheetName)
	{
		Object[][] data=null;
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			
			data = new Object[rowCount][colCount];
			
			for (int i=1; i<=rowCount;i++)
			{
				XSSFRow row = sheet.getRow(i);
				for (int j=0; j<colCount; j++)
				{
					XSSFCell cell = row.getCell(j);
					data[i-1][j] = cell.toString();
				}
			}
			workbook.close();
			fis.close();
		}
		catch (Exception e) 
		{
			System.out.println("Excel reading error. "+e.getMessage());
			e.printStackTrace();
		}
		return data;
	}

}
