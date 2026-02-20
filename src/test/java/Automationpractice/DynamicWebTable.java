package Automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebTable {

	@Test
	
	public void dynamicTable() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
				driver.manage().window().maximize();
				driver.get("https://testautomationpractice.blogspot.com/");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,2000)");
				String BranchName="Chrome";
				String percentage = driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr/td[.='"+BranchName+"']/following-sibling::td[contains(.,'%')]")).getText();
				System.out.println(percentage);
				driver.quit();
				System.out.println("hii");
		

			}

}





