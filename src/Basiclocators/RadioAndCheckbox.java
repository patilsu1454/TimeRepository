package Basiclocators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "http://toolsqa.com/automation-practice-form/";
		System.setProperty("webdriver.chrome.driver",
				"D://Selenium data//2.29//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		// Radio button

		// String xpath="//*[@name='exp']";

		List<WebElement> rd_btns = driver.findElements(By.xpath(".//*[@name='exp']"));

		if (rd_btns.get(0).isSelected()) {
			rd_btns.get(2).click();
		} else {
			rd_btns.get(4).click();
		}

		System.out.println("Succuss::required ra");

		String xpathofcheckBox = "//*[contains(@id, 'profess')]";

		// direclty you can click on particular radio/checkbox button
		// WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
		// rdBtn_Exp.click();

		List<WebElement> chkboxes = driver.findElements(By.xpath(xpathofcheckBox));
		System.out.println("Total check boxes:" + chkboxes.size());

		chkboxes.get(0).click();
		System.out.println("first checkbox is selected");
		System.out.println(driver.findElement(By.xpath("//*/div[4]/strong[1]")).getText());

	}

}
