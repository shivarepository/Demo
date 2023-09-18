package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataOperations {
	
	Object[][] data;
	DataFormatter formatter;
	public Object[][] getExceldata(String sheetName) throws IOException
	{
		String filePath = System.getProperty("user.dir") + "//TestData//InputDataFile.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		for(int i=0;i<sheetCount;i++)
		{
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rowCount = sheet.getPhysicalNumberOfRows();
				XSSFRow row = sheet.getRow(0);	
				int colCount = row.getLastCellNum();
				data = new Object[rowCount-1][colCount];
				for(int j=0;j<rowCount-1;j++)
				{
					 row = sheet.getRow(j+1);
					if(row!=null)
					{		
					for(int k=0;k<colCount;k++)
					{
						XSSFCell cell1 = row.getCell(k);
						String cell = cell1.getStringCellValue();
						data[j][k] = cell;
					}
					}else
					{
						System.out.println("Row is going to null");
					}
				}
			}
		}
		return data;
	}
}
