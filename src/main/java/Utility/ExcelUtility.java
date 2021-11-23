package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;

public class ExcelUtility {
	
	public static List<Map<String, String>>  getTestData() throws Exception {
		List<Map<String, String>> testDataAllRows=null;
		Map<String, String> testData=null;
//		String data;
//		String cellValue;
		try {
			FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Dinesh.Kanna\\eclipse-workspace\\FrameworkIGT\\Excel\\Data.xlsx");
			Workbook workbook=new XSSFWorkbook(fileInputStream);
			Sheet sheet=workbook.getSheet("Sheet1");
			int lastRowNum = sheet.getLastRowNum();
			int lastColNum = sheet.getRow(0).getLastCellNum();
			
			List list=new ArrayList();
			for (int i = 0; i < lastColNum; i++) {
				Row row = sheet.getRow(0);
				DataFormatter formatter = new DataFormatter();
				Cell cell = row.getCell(i);
				String rowHeader = cell.getStringCellValue().trim();
				list.add(rowHeader);
			}
			
			testDataAllRows=new ArrayList<Map<String,String>>();
			
			for (int j = 1; j <= lastRowNum; j++) {
				Row row = sheet.getRow(j);
				testData=new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
				for (int k = 0; k < lastColNum; k++) {
					Cell cell = row.getCell(k);
					String cellValue = cell.getStringCellValue().trim();
					testData.put((String) list.get(k), cellValue);
				}
				testDataAllRows.add(testData);
			}
			
//			for (int i = 0; i < lastRowNum; i++) {
//				Row row = sheet.getRow(i);
//				Cell cell = row.getCell(0);
//				String key = cell.getStringCellValue();
//				
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return testDataAllRows;

	}
	
//	public String getData(int rowNO, int colNo) throws Exception {
//		String data=null;
//		File file = new File(System.getProperty("user.dir")+"C:\\Users\\Dinesh.Kanna\\eclipse-workspace\\FrameworkIGT\\Excel\\Data.xlsx");
//		FileInputStream fileInputStream=new FileInputStream(file);
//		Workbook workbook=new XSSFWorkbook(fileInputStream);
//		Sheet sheet=workbook.getSheet("Sheet1");
//		Row row = sheet.getRow(rowNO);
//		Cell cell = row.getCell(colNo);
//int type = cell.getRowIndex();
//		//		CellType type = cell.getCellType();
//		if(type==1) {
//			data=cell.getStringCellValue();
//		}
//		if(type==0) {
//			if(DataUtil)
//		}
//		
//		
//		return null;
		
//	}

}
