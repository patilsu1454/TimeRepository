package Basiclocators;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Multiplewindowhandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url="http://toolsqa.com/automation-practice-switch-windows/";
		System.setProperty("webdriver.chrome.driver", "D://Selenium data//2.29//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String currentOrParentwindow=driver.getWindowHandle();
		System.out.println("Current window is: " +currentOrParentwindow);
		System.out.println();
		WebElement newWin=driver.findElement(By.xpath("//*[@id='button1']"));
		for(int i=0; i<3;i++){
			newWin.click();
			Thread.sleep(30);
			
		}
		
		Set<String> allOpenWin=driver.getWindowHandles();
		
		//Set is java.util, which allows to have only unique elements
		String lastwinHandle="";
		System.out.println("All open windows : \n");
		for(String handle : allOpenWin){
			System.out.println(handle);
			lastwinHandle=handle;
		}
		
		System.out.println("\nCurrent window before switching: " +driver.getWindowHandle());
		
		driver.switchTo().window(lastwinHandle);
		System.out.println("\nCurrent window(last) after switching: " +driver.getWindowHandle());
		
		driver.switchTo().window(currentOrParentwindow);
		System.out.println("\n switch to orginal winodw : " +driver.getWindowHandle());
	}

}