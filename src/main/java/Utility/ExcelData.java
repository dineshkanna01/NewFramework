package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getCellData(String sheetName, String colName, int rowNo) {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Admin_Data.xlsx");
			try {
				workbook=new XSSFWorkbook(fileInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int colNum=-1;
			sheet=workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			row = sheet.getRow(rowNo -1);
			cell = row.getCell(colNum);

			if(cell.getCellType()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
					Date date = cell.getDateCellValue();
					cellValue = dt.format(date);
				}
				return cellValue;
			}
			else if(cell.getCellType()==CellType.BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "data not available";
		}

	}

	public static String CC_getCellData(String sheetName, String colName, int rowNo) {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\CC_CallCenterData.xlsx");
			try {
				workbook = new XSSFWorkbook(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int colNum = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			row = sheet.getRow(rowNo - 1);
			cell = row.getCell(colNum);

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
					Date date = cell.getDateCellValue();
					cellValue = dt.format(date);
				}
				return cellValue;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "data not available";
		}

	}

	@SuppressWarnings({ "unused", "resource" })
	public static boolean write_CellData(String name, int rNum, int cNum, String Data) {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\CC_CallCenterData.xlsx";
		try {
			FileInputStream fis = new FileInputStream(path);
			try {
				Workbook workbook = new XSSFWorkbook(fis);
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		Sheet sheet = workbook.getSheet(name); // sheet at 1st tab
		int lastRow = sheet.getLastRowNum();
		for (int i = 1; i <= lastRow; i++) {
			Row row = sheet.getRow(rNum);// 2nd row (index =1)
			Cell cell = row.createCell(cNum);// column in which you want to set data
			cell.setCellValue(Data); // Data that you want to save in excel
			try {
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
			} catch (Exception e) {
			}
		}
		System.out.println("value updated in excel");
		return true;
	}

}
