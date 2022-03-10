package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
	
	static HSSFWorkbook workbook1;
	static HSSFSheet sheet1;
	static HSSFCell cell1;
	static HSSFRow row1;

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
	public static boolean write_MBCellData(String name, int rNum, int cNum, String Data) {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Admin_Data.xlsx";
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


	@SuppressWarnings("resource")
	public static boolean write_CellDataBU(String name, int rNum, int cNum, String Data) {
		try {
			String path = System.getProperty("user.dir") + "\\target\\BookingTemplate\\ResUpload" + " "
					+ "Template.xls";
			FileInputStream fis = new FileInputStream(path);
			HSSFWorkbook workbook1 = new HSSFWorkbook(fis, false);
			HSSFSheet sheet1 = (HSSFSheet) workbook1.getSheet(name); // sheet at 1st tab
			int lastRow = sheet1.getLastRowNum();
			for (int i = 1; i <= lastRow; i++) {

				if (sheet1.getRow(rNum) == null) {
					sheet1.createRow(rNum);
				}

				HSSFRow row1 = sheet1.getRow(rNum);// 2nd row (index =1)
				HSSFCell cell1 = (HSSFCell) row1.createCell(cNum);// column in which you want to set data
				cell1.setCellValue(Data); // Data that you want to save in excel
				FileOutputStream fos = new FileOutputStream(path);
				workbook1.write(fos);
				fos.close();
			}
			System.out.println("value updated in excel");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	public static String getCellDataResUpload(String sheetName, int colName, int rowNo) {
		FileInputStream fileInputStream;
		try {
			File dir = new File(System.getProperty("user.dir") + "\\target\\BookingTemplate");
			File[] files = dir.listFiles();
			if (files == null || files.length == 0) {
				return null;
			}

			File lastModifiedFile = files[0];
			for (int i = 1; i < files.length; i++) {
				if (lastModifiedFile.lastModified() < files[i].lastModified()) {
					lastModifiedFile = files[i];
				}
			}
			fileInputStream = new FileInputStream(lastModifiedFile);

			try {
				workbook1 = new HSSFWorkbook(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sheet1 = workbook1.getSheet(sheetName);

			String data = sheet1.getRow(rowNo).getCell(colName).getStringCellValue();
			return data;


		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "data not available";
		}

	}
}
