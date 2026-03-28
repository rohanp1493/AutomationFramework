package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		
		File xlsxFile = new File(System.getProperty("user.dir")+"//testData//" + fileName);
		
		//XLSX File
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = new ArrayList<User>();
		Row row;
		Cell emailCell;
		Cell passwordCell;
		User user;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			Iterator<Row> rowIterator = xssfSheet.iterator();
			rowIterator.next(); //Skipping the column name
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailCell.toString(), passwordCell.toString());
				userList.add(user);
			}
			xssfWorkbook.close();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
		

	}

}
