package Automationpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) {

		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://testautomationpractice.blogspot.com/");

		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		      
		        WebElement table = driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
		        js.executeScript("arguments[0].scrollIntoView(true);", table);

		        boolean found = false;

		        while (!found) {

		            // Get all rows of current page
		            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

		            for (int i = 1; i <= rows.size(); i++) {

		                String productName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[2]")).getText();

		                if (productName.equalsIgnoreCase("E-Reader")) {

		                    // Print price
		                    String price = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[3]")).getText();
		                    System.out.println("Price of E-Reader: " + price);

		                    // Click checkbox
		                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).click();
		                    System.out.println("Checkbox clicked");

		                    found = true;
		                    break;
		                }
		            }

		            // If not found, click next page number
		            if (!found) {

		                List<WebElement> nextPage = driver.findElements(
		                        By.xpath("//ul[@class='pagination']//li[@class='active']/following-sibling::li[1]/a"));

		                if (nextPage.size() > 0) {
		                    nextPage.get(0).click();
		                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTable")));
		                } else {
		                    break;  // No more pages
		                }
		            }
		        }

		        driver.quit();
		    }
		}