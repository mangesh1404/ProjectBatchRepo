package com.testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.TestBase.TestBase;

public class ExcelUtils {

	File f=null;
	FileInputStream fis=null;
	XSSFWorkbook wb=null;
	XSSFSheet sh=null;
	FileOutputStream fos;
	
	public String getStringdata(String sheetname, int row , int col) {
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"/Testdata.xlsx");
			wb=new XSSFWorkbook(fis);	
		} catch (IOException e) {
			TestBase.logger.error("control in catch block and error is "+e.getStackTrace());
			e.printStackTrace();
		}
		sh=wb.getSheet(sheetname);
		String data=sh.getRow(row).getCell(col).getStringCellValue();
		return data;
	}	
	public int getIntdata(String sheetName, int row , int col) {
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"/Testdata.xlsx");
			wb=new XSSFWorkbook(fis);	
		} 
		catch (IOException e) {
			TestBase.logger.error("control in catch block and error is "+e.getStackTrace());
			e.printStackTrace();
		}
		sh=wb.getSheet(sheetName);
		
		double d=sh.getRow(row).getCell(col).getNumericCellValue();
		int data=(int)d;
		return data;
	}
	
	
	public void writeData(String sheetName, int row, int col, String data) {
		
		try {
			f= new File(System.getProperty("user.dir")+"/Testdata.xlsx");
			fis=new FileInputStream(f);
			wb=new XSSFWorkbook(fis);	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		sh=wb.getSheet(sheetName);
		sh.getRow(row).createCell(col).setCellValue(data);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			wb.write(fos);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}
	}
