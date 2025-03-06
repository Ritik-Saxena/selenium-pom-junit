package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private boolean isModified = false;
	private String filePath;
	
	public ExcelUtils(String sheetName) {
		// getting absolute path of file from relative path
		String relativeExcelFilePath = ConfigReader.getProperty("excel_file_path");
		this.filePath = Paths.get(relativeExcelFilePath).toAbsolutePath().toString();
		
		try {
			FileInputStream fileRead = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fileRead);
			sheet = workbook.getSheet(sheetName);
			
		} catch(IOException e) {
			throw new RuntimeException("Error reading the excel file", e);
		}
	}
	
	public int getTotalRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public void setCellData(int rowNum, int columnNum, String data) {
		if (sheet.getRow(rowNum)==null) {
			sheet.createRow(rowNum);
		}
		
		Cell requiredCell = sheet.getRow(rowNum).getCell(columnNum);
		if (requiredCell==null) {
			requiredCell = sheet.getRow(rowNum).createCell(columnNum);
		}
		
		requiredCell.setCellValue(data);
		isModified = true;
	}
	
	public String getCellData(int rowNum, int columnNum) {
		if (sheet.getRow(rowNum)==null || sheet.getRow(rowNum).getCell(columnNum)==null) {
			return "";
		}
		
		return sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
	}
	
	public void saveAndClose() {
		try {
			if (isModified==true) {
				FileOutputStream fileWrite = new FileOutputStream(this.filePath);
				workbook.write(fileWrite);
			}
		} 
		catch (IOException e) {
			throw new RuntimeException("Error saving the excel file", e);
		} 
		finally {
			try {
				workbook.close();
			}
			catch (IOException e) {
				throw new RuntimeException("Error closing the workbook", e);
			}
		}
	}
}

