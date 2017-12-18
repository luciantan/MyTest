import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

class MyTest {

	private static WebDriver driver = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/luntan/downloads/chromedriver");
		driver = new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.close();
	}


	@Test
	void test() {
		String url = "https://www.google.com";
		driver.get(url);
		
		WebElement inputBox = driver.findElement(By.id("lst-ib"));
		inputBox.sendKeys("microstrategy");
		
		WebElement searchButton = driver.findElement(By.cssSelector("#tsf > div.tsf-p > div.jsb > center > input[type=\'submit\']:nth-child(1)"));
		searchButton.click();
		
		WebElement msLink = driver.findElement(By.partialLinkText("Powerful Data Analytics"));
		msLink.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'blog\']/div/div[2]/a")));
		driver.findElement(By.xpath("//*[@id=\'blog\']/div/div[2]/a")).click();
		
		String expectedUrl = "https://www.microstrategy.com/us/blog";
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expectedUrl, actualUrl);
	}

}
