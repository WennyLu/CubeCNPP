package cnpp.Framework;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static Object[][] getDataFromExcel(String excelFileName, String sheetName) {
		Object[][] obj = null;
		InputStream is = ReadExcel.class.getClassLoader().getResourceAsStream(excelFileName);
		Workbook wb = null;
		Sheet sheet = null;
		try {
			wb = new XSSFWorkbook(is);
			sheet = wb.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
			obj = new Object[lastRowNum][lastCellNum];
			for (int i = 0; i <= lastRowNum; i++) {
				for (int j = 0; j < lastCellNum; j++) {
					obj[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				wb.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}

		return obj;

	}
}