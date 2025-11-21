package Twentiethday;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExistingBrowser {

	static ChromeDriver driver;
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:1992");
		driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
//		driver.get("https://www.linkedin.com/feed/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement CartButton = driver.findElement(By.xpath("//img[@alt='Cart']"));
		CartButton.click();
		

	}

}
