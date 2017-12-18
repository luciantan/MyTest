import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

public class TestBaidu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/luntan/downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
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
		
		driver.close();
	}

}
