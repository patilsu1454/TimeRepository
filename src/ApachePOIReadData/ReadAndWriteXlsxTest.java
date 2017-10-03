package ApachePOIReadData;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ReadAndWriteXlsxTest {
	
	static String filePath="D://Selenium data//ReadAndWrite.xlsx";
	static String sheetName="SheetTest";
	
	static String newFilePath="D://Selenium data";
	static String dataToWrite[]={"Sushant", "Suprit", "Ashwini", "Teju"};
	static String sheetNameN="SHEETNEW";
	
public static void main(String[] args) throws InvalidFormatException, IOException {
		
		System.out.println("Reading from xlsx based on row index");
		ArrayList<String> reqAllColValues=(ArrayList<String>) ReadDataFromXlxs.allColValues(filePath, sheetName, 7);
		
		System.out.println(reqAllColValues);
		
		System.out.println(reqAllColValues.get(0));
				
		System.out.println("Creating new file and writing "); 
		
		ReadDataFromXlxs.writeExcel(newFilePath, "FileXLXS",sheetNameN,dataToWrite, 3, 5 );  // insert text at row 3 col 5  (F col, 4th row)
				
		System.out.println("Succussfull write");
		
		System.out.println("Iterate all values xls sheet");
		
		String[][] m=ReadDataFromXlxs.allColValues1(filePath, sheetName);
		System.out.println("multi dimensional array length is:"+m[0].length);
		
		for(int i=0; i<m.length; i++){
			
			for(int j=0; j<m[i].length;j++){
				System.out.print(m[i][j]);
				if(j<m[i].length-1){
			System.out.print(",");
				}
			}System.out.println();
		}
		
		System.out.println("************");
		System.out.println(m[0][0]);
		System.out.println(m[0][1]);
		System.out.println(m[0][2]);
	//	System.out.println(m[0][3]); since size is '3' not 4
		System.out.println(m[1][0]);
		System.out.println(m[1][1]);
	
	}
}
 