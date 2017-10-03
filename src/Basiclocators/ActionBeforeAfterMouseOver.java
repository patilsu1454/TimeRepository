package Basiclocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionBeforeAfterMouseOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	   String url="http://newtours.demoaut.com/";
	   System.setProperty("webdriver.chrome.driver", "D://Selenium data//2.29//chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   
	   driver.get(url);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
	//	String beforeXpath="html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]";
		String beforeXpath="//html/body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td//table/tbody/tr";
		
		WebElement el_home=driver.findElement(By.xpath(beforeXpath));
		String bef_color=el_home.getCssValue("background-color");
		System.out.println("Before color" +bef_color);
		
		WebElement link_Home = driver.findElement(By.linkText("Home"));
		
		Actions act=new Actions(driver);
		Action mo=act.moveToElement(link_Home).build();  // imp actions and action
		mo.perform();
		
		String afColor = el_home.getCssValue("background-color");
        System.out.println("After hover: " + afColor);
       // driver.close();
          
       }
				
	}


