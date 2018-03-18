package com.test.automation.UiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	
	public FileOutputStream fileout=null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public ExcelReader(String path)
	{
			this.path=path;
			try {
				fis=new FileInputStream(path);
				workbook=new XSSFWorkbook(fis);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	public String[][] getDataFromSheet(String sheetname,String ExcelName)
	{
		String dataSets[][]=null;
		try
		{
		
		sheet=workbook.getSheet(sheetname);
		int totalRow=sheet.getLastRowNum()+1;
		System.out.println(">>>>Toral row"+totalRow);
		int totalColumn=sheet.getRow(0).getLastCellNum();
		dataSets =new String[totalRow-1][totalColumn];
		for(int i=1;i<totalRow;i++)
		{
			row=sheet.getRow(i);
				for(int j=0;j<totalColumn;j++)
				{
					
					cell=row.getCell(j);
					if(cell.getCellType()==Cell.CELL_TYPE_STRING)
					{
						dataSets[i-1][j]=cell.getStringCellValue();
						
					}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
					{
						dataSets[i-1][j]=cell.getStringCellValue();
						
					}else
						dataSets[i-1][j]=String.valueOf(cell.getBooleanCellValue());
								
				}
		}
		return dataSets;
		
	}catch(Exception e)
		{
		System.out.println("Exception in reading excel file" +e.getMessage());
		
		e.printStackTrace();
		}
		return dataSets;
}
	
	public String getCellData(String sheetname,String ColName,int rowNum)
	{
		try
		{
			
			int col_num=0;
			int index=workbook.getSheetIndex(sheetname);
			sheet=workbook.getSheetAt(index);
			XSSFRow row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().equals(ColName))
				{
					col_num=i;
					break;
				}
				
			}
			
			row=sheet.getRow(rowNum-1);
			XSSFCell	 cell=row.getCell(col_num);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			{
				return cell.getStringCellValue();
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			{
				return "";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
