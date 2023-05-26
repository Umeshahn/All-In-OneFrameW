package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcelSheet {

	private static XSSFSheet sheet = null;

	public static XSSFWorkbook getExcelFile(String excelFileName) {
		FileInputStream fis = null;
		XSSFWorkbook xssfWorkbook = null;
		try {
			// Creating a New File Instances
			File file = new File(System.getProperty("user.dir") + "/src/main/resources/" + excelFileName + ".xlsx");

			// Obtaining a bytes from file
			fis = new FileInputStream(file);

			// creating a workbook instance to refers to .xlsx file
			xssfWorkbook = new XSSFWorkbook(fis);

		} catch (IOException e) {
			e.printStackTrace();
			Log.error("The error message is" + e.getMessage());
		}

		return xssfWorkbook;
	}

	public static XSSFSheet getSheet(String excelFileName, String excelSheetName) {

		try {

			// creating a sheet object to retrieve the object
			sheet = getExcelFile(excelFileName).getSheet(excelSheetName);

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("The error message is" + e.getMessage());
		}
		return sheet;
	}

	public static String getCellValue(int RowNum, int columnNum) {
		XSSFCell cell = sheet.getRow(RowNum).getCell(columnNum);

		String cellValue;
		CellType hello = cell.getCellType();
		switch (hello) {
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case BLANK:
			cellValue = String.valueOf(cell.getRawValue());
			break;
		default:
			cellValue = String.valueOf(cell.getErrorCellValue());
			break;

		}
		return cellValue;

	}

	public static void getTestData(String excelName, String excelSheetName, String headerName, String fileName) {
		int headerRow = -1;
		int headerCoulumnCout = 0;
		try {

			sheet = getSheet(excelName, excelSheetName);

			int totalRowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 0; i <= totalRowCount; i++) {
				String value1 = getCellValue(i, 0);

				if (value1.equals("User")) {
					headerRow = i;
				}

			}
			Log.message("The Header Row is " + headerRow);

			// creating a loop over all the rows of excel sheet file to read it

			int num = -1;

			// This is to identify the File name or ModuleName in 1st Row
			for (int i = 0; i <= totalRowCount; i++) {
				Row row = sheet.getRow(i);
				String value1 = getCellValue(i, 0);
				if (value1.equals("LoginTestData")) {
					System.out.println("The value is " + value1);
					num = i;

					// This is to iterate the Value from O to get the Column Name/Header Name
					for (int j = 0; j < row.getLastCellNum(); j++) {

						// This is to get the Cell Value based on File/Module Row Number
						for (int k = num; k <= totalRowCount; k++) {
							String cellValue4 = getCellValue(k, j);
							if (cellValue4.equals("null")) {
								break;
							} else {
								String columnName;
								if (headerCoulumnCout == 0) {
									columnName = getCellValue(headerRow, j);
									if (columnName.equals("null"))
										break;

								} else {
									columnName = getCellValue(headerRow, j) + "" + headerCoulumnCout;

								}
								System.out.println(columnName + " : " + cellValue4);
								headerCoulumnCout++;

							}

						}
						headerCoulumnCout = 0;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("The error message is " + e.getMessage());
		}

	}

	public static void main(String[] arg) {
		try {

//			//Creating a New File Instances
//			File file = new File(System.getProperty("user.dir")+"/src/main/resources/TestData.xlsx");
//			
//			//Obtaining a bytes from file
//			FileInputStream fis = new FileInputStream(file);
//			
//			//creating a workbook instance to refers to .xlsx file
//			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
//			
//			//creating a sheet object to retrieve the object
//			XSSFSheet xssfSheet = xssfWorkbook.getSheet("TestDataSheet1");
//			

			sheet = getSheet("TestData", "TestDataSheet1");

			int totalRowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println("The Totla Row number count is " + totalRowCount);
			int headerRow = -1;

			int headerCoulumnCout = 0;

			for (int i = 0; i <= totalRowCount; i++) {
//				String value1 = sheet.getRow(i).getCell(0).getStringCellValue();
				String value1 = getCellValue(i, 0);

				if (value1.equals("User")) {
					System.out.println("The value is " + value1);
					headerRow = i;
				}

			}
			System.out.println("The Header Row is " + headerRow);

			// creating a loop over all the rows of excel sheet file to read it

			int num = -1;

			// This is to identify the File name or ModuleName in 1st Row
			for (int i = 0; i <= totalRowCount; i++) {
				Row row = sheet.getRow(i);
				String value1 = getCellValue(i, 0);
				if (value1.equals("HomeTestData")) {
					System.out.println("The value is " + value1);
					num = i;

					// This is to iterate the Value from O to get the Column Name/Header Name
					for (int j = 0; j < row.getLastCellNum(); j++) {

						// This is to get the Cell Value based on File/Module Row Number
						for (int k = num; k <= totalRowCount; k++) {
							String cellValue4 = getCellValue(k, j);
							if (cellValue4.equals("null")) {
								break;
							} else {
								String columnName;
								if (headerCoulumnCout == 0) {
									columnName = getCellValue(headerRow, j);
									if (columnName.equals("null"))
										break;

								} else {
									columnName = getCellValue(headerRow, j) + "" + headerCoulumnCout;

								}
								System.out.println(columnName + " : " + cellValue4);
								headerCoulumnCout++;

							}

						}
						headerCoulumnCout = 0;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getStackTrace();
			System.out.println("The error message is " + e.getMessage() + e.getLocalizedMessage());
		}
	}

}
