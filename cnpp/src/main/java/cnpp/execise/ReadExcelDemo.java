package cnpp.execise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {
	public static void main(String[] args) throws IOException {
		Workbook wb = new XSSFWorkbook(new FileInputStream(
				new File("D:\\Users\\WenyiLU\\workspace\\cnpp\\src\\test\\resources\\test-data.xlsx")));
		Sheet sheet = wb.getSheet("LoginData");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
		// System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
		// System.out.println(sheet.getRow(lastRowNum).getCell(lastCellNum-1).getStringCellValue());
		System.out.println(lastRowNum);
		System.out.println(lastCellNum);
		for (int i = 0; i <= lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + "\t");
			}
			System.out.println();
		}
		wb.close();
	}
}
