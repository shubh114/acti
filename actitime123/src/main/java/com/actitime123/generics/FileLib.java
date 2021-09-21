package com.actitime123.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Generic class for data driven testing
 * @author shubh
 *
 */
public class FileLib {
/**
 * generic method to read the data from property file
 * @param key
 * @return String
 * @throws IOException
 */
	public String getPropertyData(String key) throws IOException{
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	/**
	 * generic method to read the data from excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return String
	 * @throws IOException
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public String getExcelData(String sheet,int row,int cell) throws IOException, EncryptedDocumentException, InvalidFormatException{
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	/**
	 * generic method to write the data to excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @throws IOException
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public void setExcelData(String sheet,int row,int cell,String data) throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}
}
