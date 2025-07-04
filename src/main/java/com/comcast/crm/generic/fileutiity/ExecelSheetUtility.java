package com.comcast.crm.generic.fileutiity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Handling the excel sheet 
 * using apache poi tool
 */
public class ExecelSheetUtility {
    /**
     * getting data from the excel sheet using parameter
     * @param sheet
     * @param row
     * @param cell
     * @return String
     * @throws EncryptedDocumentException
     * @throws IOException
     */
	public String getDataFromExcelSheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		/*
		 * create instance for FileInputStream
		 * open the excel sheet using the location
		 */
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\santhosh\\\\eclipse-workspace\\\\teypyramidpractice\\\\src\\\\test\\\\resources\\\\TestData2.xlsx");
		/*
		 * load all the sheets 
		 * open the workbook
		 */
		Workbook wb = WorkbookFactory.create(fis);
		/*
		 * pass sheet name, row, cell into respected methods
		 * get data from the cell 
		 */
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		/*
		 * close the workbook
		 */
		wb.close();
		/*
		 * return the data 
		 */
		return data;
	}
	/**
	 * get the last row from the particular sheet
	 * @param sheet
	 * @return int
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRow(String sheet) throws EncryptedDocumentException, IOException {
		/*
		 * create instance for FileInputStream
		 * open the excel sheet using the location
		 */
		FileInputStream fis=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\src\\test\\resources\\TestData2.xlsx");
		/*
		 * load all the sheets 
		 * open the workbook
		 */
		Workbook wb = WorkbookFactory.create(fis);
		/*
		 * get the last row using sheet name 
		 */
		int lastrow = wb.getSheet(sheet).getLastRowNum();
		/*
		 * return the last row
		 */
		return lastrow;
		
	}
	/**
	 * getting the last cell index
	 * @param sheet
	 * @param row
	 * @return int
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastCell(String sheet, int row) throws EncryptedDocumentException, IOException {
		/*
		 * create instance for FileInputStream
		 * open the excel sheet using the location
		 */
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\santhosh\\\\eclipse-workspace\\\\teypyramidpractice\\\\src\\\\test\\\\resources\\\\TestData2.xlsx");
		/*
		 * load all the sheets 
		 * open the workbook
		 */
		Workbook wb = WorkbookFactory.create(fis);
		/*
		 * get last cell index 
		 * passing sheet name,row to respected methods
		 */
		int lastcell = wb.getSheet(sheet).getRow(row).getLastCellNum();
		/*
		 * return the last cell index
		 */
		return lastcell;
		
	}
	
	/**
	 * set the value into excel sheet 
	 * @return void
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param cellvalue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataInToExcelSheet(String sheet, int row, int cell,String cellvalue) throws EncryptedDocumentException, IOException 
	{
		/*
		 * location of the excel file
		 */
String filePath = "C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\src\\test\\resources\\TestData2.xlsx"; 
        /*
         * 
         */
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = WorkbookFactory.create(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
             Sheet sheet1 = wb.getSheet (sheet);
            if (sheet1 == null) {
                sheet1 = wb.createSheet(sheet);
            }
            Row row1 = sheet1.getRow(row);
            if (row1 == null) {
                row1 = sheet1.createRow(row);
            }
            Cell cell1 = row1.createCell(cell); 
            cell1.setCellValue(cellvalue); 
            wb.write(fos);
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
		
	}
	
	
	public Object [][] readMultipleDataFromExcel(String sheet,int row,int cell ) throws EncryptedDocumentException, IOException {
		Object [][] ary=new Object[row][cell];
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\santhosh\\\\eclipse-workspace\\\\teypyramidpractice\\\\src\\\\test\\\\resources\\\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet esheet = wb.getSheet(sheet);
	// int lastrow = esheet.getLastRowNum();
	//int lastcell = esheet.getRow(lastrow).getLastCellNum();
		int i=1;int j=0;
		for(;i<row;i++) {
			Row erow = esheet.getRow(row);
			for(;j<cell;j++) {
				ary[i][j]=erow.getCell(j).getStringCellValue();
			}
		}

		return ary;

	}
}
