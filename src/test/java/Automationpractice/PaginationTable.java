package Automationpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class PaginationTable {

@Test
public void paginationtble() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     JavascriptExecutor js = (JavascriptExecutor) driver;

     // Scroll to Pagination Table
     WebElement tableHeader = driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
     js.executeScript("arguments[0].scrollIntoView(true);", tableHeader);


	String targetProduct = "E-Reader";
	boolean found = false;

	List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li/a"));
	int totalPages = pages.size();

	System.out.println("Total Page = " + totalPages);

	for (int i = 1; i <= totalPages; i++) {

		
		driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()='" + i + "']")).click();
		Thread.sleep(1200);

		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

		for (WebElement row : rows) {
			String name = row.findElement(By.xpath("./td[2]")).getText();

			if (name.equalsIgnoreCase(targetProduct)) {
				
				row.findElement(By.xpath("./td[4]/input")).click();
				System.out.println("Selected Product: " + name + " on Page " + i);
				found = true;
				break; 
			}
		}

		if (found) {
			break; 
		}
	}

	if (!found) {
		System.out.println("Product not found!");
		System.out.println("hii");
	}
	

}
}
	
	