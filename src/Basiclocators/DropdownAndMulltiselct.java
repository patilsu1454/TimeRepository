package Basiclocators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownAndMulltiselct {

	public static void main(String[] args) {
	
		String url="http://toolsqa.com/automation-practice-form/";
		System.setProperty("webdriver.chrome.driver", "D://Selenium data//2.29//chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   
	   driver.get(url);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	   
	   WebElement dropDown=driver.findElement(By.xpath("//*[@id='continents']"));
	   Select sdrop=new Select(dropDown);
	   System.out.println("drop down is multiselect:" +sdrop.isMultiple());
	   sdrop.selectByIndex(3);	
	  
	  	      		
	   
		// Step 6: Print all the options for the selected drop down and select one option of your choice
		// Get the size of the Select element
		   	   
	   
	   List<WebElement> list=sdrop.getOptions();
	   int size=list.size();
	   System.out.println("********");
	   System.out.println(list);
	 
	   for(int i=0; i<size;i++){
		   
		   String svalue=sdrop.getOptions().get(i).getText();
		   System.out.println("Option :"+svalue);
		   
		   if(svalue.equals("Europe")){
			   sdrop.selectByIndex(4);//selectByVisibleText(svalue);  
				break;    // comes out of for loop
						   }
		   	   }
	   
	   
		   
	   WebElement Multipleselectbox=driver.findElement(By.xpath("//*[@id='selenium_commands']"));   
	   Select so= new Select(Multipleselectbox);
	   System.out.println("Is multiple select box :" +so.isMultiple());
	   
	   System.out.println("Multi selection");
	   so.selectByIndex(0);
	   so.selectByVisibleText("Navigation Commands");
	   System.out.println("Both options selected based on index and visible text at the same time");
	   
	   
	// Step 6: Print all the options for the selected drop down and select one option of your choice
	// Get the size of the Select element
	   
	// sdrop.getOptions().get(1).isSelected();
	//  sdrop.deselectByIndex(i); 
	}

}
