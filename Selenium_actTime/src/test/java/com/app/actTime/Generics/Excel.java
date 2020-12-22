package com.app.actTime.Generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static int getRowCount(String path, String sheet) {
		int rc = -1;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc = wb.getSheet(sheet).getLastRowNum();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rc;
	}

	public static String getData(String path, String sheet, int row, int col) {
		String val = "";
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			val = wb.getSheet(sheet).getRow(row).getCell(col).toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return val;
	}
}
