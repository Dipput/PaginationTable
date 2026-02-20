package Automationpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonMarathi {

	@Test
	
	public void Marathi()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		WebElement click = driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//span[text()='मराठी']/preceding-sibling::i[@class='icp-radio']"));
		 driver.quit();
		System.out.println("hello");
		
	}
}
