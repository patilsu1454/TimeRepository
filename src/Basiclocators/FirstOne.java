package Basiclocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstOne {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium data//2.29//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // WebDriver is an interface and driver is reference of interface
		
		//FirfoxDriver is class, object of this class is assigned to driver and hence FireFixDriver class 
		//implements WebDriver interface
   driver.get("https://in.linkedin.com");
   driver.findElement(By.id("login-email")).sendKeys("sushantpatilbld@gmail.com");
   driver.findElement(By.id("login-password")).sendKeys("shankargoudap");
   driver.findElement(By.id("login-submit")).click();
   System.out.println("Login succuss");
		Thread.sleep(20);
 WebElement element= driver.findElement(By.xpath("html/body/nav/div/form/div[1]/div/section/div/div/div[1]/div/div/input"));
 element.clear();
 element.sendKeys("Sushant Patill");
  
  // driver.close(); //close the driver
	}

}
