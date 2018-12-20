package helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import helper.logger.LoggerHelper;

public class ExcelHelper {

	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));

			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Create sheet instance
			HSSFSheet sheet = workbook.getSheet(sheetName);

			// Count number of active rows
			int totalRowNum = sheet.getLastRowNum();

			// Count Active columns in row
			int totalColumnNum = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRowNum][totalColumnNum - 1];

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;

			while (rowIterator.hasNext()) {
				i++;
				// For Every row we need to iterate through columns
				HSSFRow row = (HSSFRow) rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {

					HSSFCell cell = (HSSFCell) cellIterator.next();
					if (cell.getStringCellValue().contains("Start")) {
						i = 0;
						break;
					}
					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataSets[i - 1][j++] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i - 1][j++] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i - 1][j++] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i - 1][j++] = cell.getCellFormula();
						break;

					default:
						log.info("No matching ENUM Type Found");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			log.info(e.getCause());
			e.printStackTrace();
		}
		return null;
	}

	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus) {
		try {
			FileInputStream file = new FileInputStream(new File(excelLocation));
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			// Create sheet instance
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRowCount = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRowCount; i++) {
				HSSFRow row = sheet.getRow(i);
				String cell = row.getCell(0).getStringCellValue();
				if (cell.contains(testCaseName)) {
					row.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("Test Case Status has been updated");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}

		} catch (Exception e) {

		}
	}

}
