package com.crm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.baseclass.TestBase;



public class TestUtil extends TestBase{

	public static long PAGE_TIME_OUT =20;
	public	static long IMPLICI_WAIT =10;

	public static String TEST_SHEET_PATH ="C:\\QA2022\\Selenium_Workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\testdata\\Book1.xlsx";

	static Workbook book;
	static Sheet sheet;
	



	public static Object[][] getTestData(String sheetname){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_SHEET_PATH);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book= WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		
			
		}


		sheet =book.getSheet(sheetname);
		Object [][]data =  new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i<sheet.getLastRowNum(); i++) {
			for (int k =0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;

	}
	public void getScreenshot () throws IOException {
		Date currentdate = new Date();
		String screenShotFileName = currentdate.toString().replace(" ", "_").replace(":", "_");
		File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File("./screenshot//"+ screenShotFileName+".png"));
		
		
	}
}
	
	

