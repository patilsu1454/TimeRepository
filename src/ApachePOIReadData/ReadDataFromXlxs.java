package ApachePOIReadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromXlxs {

	
	public static ArrayList<String> allColValues(String filePath, String sheetName,
			int rowNo) throws InvalidFormatException, IOException {
		
		ArrayList<String> al= new ArrayList<String>();
		try {
			
			FileInputStream fis=new FileInputStream(filePath);
			
			Workbook wb= WorkbookFactory.create(fis);
			
			Sheet sh=(Sheet) wb.getSheet(sheetName);
			
			
			Row row = ((org.apache.poi.ss.usermodel.Sheet) sh).getRow(rowNo);
			 
			int s= row.getLastCellNum()-row.getFirstCellNum();
			
			for(int i=0; i<s; i++){
						
				al.add(row.getCell(i).getStringCellValue());
				
			}
			
			
		} catch (FileNotFoundException | EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
	
			
	public static void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite, int rowNo, int colNo) throws IOException {
				
		FileOutputStream fileOut = new FileOutputStream(filePath+"\\"+fileName+".xlsx");
		Workbook wb1=new XSSFWorkbook();
		Sheet sheet1 = wb1.createSheet(sheetName);
		Row row = sheet1.createRow(rowNo);
		Cell cell = row.createCell(colNo);
		cell.setCellValue(dataToWrite[0]);
		Cell cell1 = row.createCell(colNo+1);
		cell1.setCellValue(dataToWrite[1]);
		wb1.write(fileOut);
		fileOut.close();
		
		/*File file = new File(filePath+"\\"+fileName+".xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
s		XSSFSheet sh1= wb.getSheetAt(0);
		
		 sh1.getRow(0).createCell(2).setCellValue(dataToWrite[0]);
		 
		 sh1.getRow(1).createCell(2).setCellValue(dataToWrite[1]);
		 
		 sh1.getRow(2).createCell(2).setCellValue(dataToWrite[2]);
				 
		 FileOutputStream fout=new FileOutputStream(file);
		 */
	//	 wb.write(fout);
//		 fout.close();
		
		
	}
	
	
	public static String[][] allColValues1(String filePath, String sheetName) throws InvalidFormatException, IOException {
		
		String[][] str=null;
		try {
			
			FileInputStream fis=new FileInputStream(filePath);
			
			Workbook wb= WorkbookFactory.create(fis);
			
			Sheet sh=(Sheet) wb.getSheet(sheetName);
			System.out.println(sh.getLastRowNum());
			int cj=0;
			str= new String[7][3];
			for(int j=1; j<=sh.getLastRowNum(); j++, cj++){
			
			Row row = ((org.apache.poi.ss.usermodel.Sheet) sh).getRow(j);
			 
			//int s= row.getLastCellNum()-row.getFirstCellNum();
			int ci=0;
			
			for(int i=0; i<=2; i++, ci++){
						//System.out.println(row.getCell(i).getStringCellValue());
						//System.out.println(str[ci][cj]);
				str[cj][ci]=row.getCell(i).getStringCellValue();
				
			}
			
			}
			
		} catch (FileNotFoundException | EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
			
	}
	
	}
