package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook workbook;

	public ExcelReader(String filepath) throws IOException {
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}
	
	public int getTotalRowCount(int sheetindex)
	{
		return workbook.getSheetAt(sheetindex).getLastRowNum()+1;
	}
	
	public int getTotalColumnCount(int sheetindex)
	{
		
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
			
	}
	
	public Object getSpecificSheetData(int sheetindex,int row,int columns)
	{
		XSSFCell cell=workbook.getSheetAt(sheetindex).getRow(row).getCell(columns);
		if(cell==null)
		{
			return "";
			
		}
		if(cell!=null)
		{
			if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
			{
				return cell.getNumericCellValue();
			}
			else if(cell.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN)
			{
				return cell.getBooleanCellValue();
			}
			else if(cell.getCellType()==XSSFCell.CELL_TYPE_FORMULA)
			{
				return cell.getCellFormula();
			}
			
		}
		return null;
		
	}
	public Object[][] getAllSheetData(int sheetindex)
	{
		int rows=getTotalRowCount(sheetindex);
		int cells=getTotalColumnCount(sheetindex);
		
		Object[][]data=new Object[rows][cells];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cells;j++)
			{
				data[i][j]=getSpecificSheetData(sheetindex,i, j);
			}
		}
		return data;
	}
}