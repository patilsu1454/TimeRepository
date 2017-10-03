package Basiclocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionMenuToSubmenu {

	public static void main(String[] args) {
		
		
		String url="http://www.guru99.com/keyboard-mouse-events-files-webdriver.html";
		   System.setProperty("webdriver.chrome.driver", "D://Selenium data//2.29//chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   
		   driver.get(url);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
			
		//	String beforeXpath="html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]";
			String sapMainMenu ="//*[@id='g-navigation']/div/div/div[2]/div/nav/ul/li[3]/a";
			String SapFicoSubMenu="//*[@id='g-navigation']/div/div/div[2]/div/nav/ul/li[3]/ul/li/div/div[1]/ul/li[5]/a";
			
WebElement elMain= driver.findElement(By.xpath(sapMainMenu));
Actions act=new Actions(driver);
act.moveToElement(elMain);

WebElement elSub=driver.findElement(By.xpath(SapFicoSubMenu));
act.moveToElement(elSub);
act.click().build().perform();
System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());

 
	}

}
