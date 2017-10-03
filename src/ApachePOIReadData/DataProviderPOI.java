package ApachePOIReadData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPOI {

	// public static Sheet sh;bbkbkjb
	//khhkjhkj
	//hjkhj
	public static String str[][];
	public static WebDriver driver;
	public static Cell cell1=null;
	static String url = "https://www.linkedin.com";

	@AfterTest
	public static void close_sessions() {
		driver.close();
	}
					

	@BeforeTest
	public static WebDriver startBrowser() {
		System.out.println("-Chrome");
		System.setProperty("webdriver.chrome.driver",
				"D://Selenium data//2.29//chromedriver.exe");
		driver = new ChromeDriver();
		// driver= new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	@DataProvider(name = "getDataFromXlsx")
	public Object[][] getDataFromXlsx() throws EncryptedDocumentException,
			IOException {
		Object[][] obj = null;
		obj = getFromMethod(
				"C:\\Users\\admin\\Desktop\\SVNworkspace\\LoginOneTest.xlsx",
				"Sheet1");
		return obj;
	}
	
	
	
	public String[][] getFromMethod(String path, String sheetName)
			throws IOException{

		FileInputStream fis = new FileInputStream(path);

		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(1);
//	System.out.println("Row numbers:"+sh.getLastRowNum());
	//System.out.println("Row numbers:"+row.getPhysicalNumberOfCells());
		//Cell cell = row.getCell(0);
//String st=cell1.getStringCellValue().toString();

		int startRow=1,startCol=0,totalRows=(sh.getLastRowNum()-1),totalCol=(row.getPhysicalNumberOfCells()-1);
		
		int ci=0;
				
		for(int i=startRow;i<=totalRows; i++,ci++ ){
			row=sh.getRow(i);
			int cj=0;
			for(int j=startCol; j<=totalCol; j++,cj++){
				cell1= row.getCell(j);
				 str[ci][cj]=cell1.getStringCellValue();
						
			}
		}
		return str;
	}

	@Test(dataProvider="getDataFromXlsx")
	public void testMethod(String uname, String pwd) {
		
		System.out.println("uname :" + uname + "   Password :" + pwd);
	}
	
	
	
}


