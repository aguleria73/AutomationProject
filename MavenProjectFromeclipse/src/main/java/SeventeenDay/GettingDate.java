package SeventeenDay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GettingDate {

	static FirefoxDriver driver;
	
	
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement LoginModal = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/div[2]/div/section[2]/span/img"));
		LoginModal.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement DepartureDate = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div[2]"));
		DepartureDate.click();

	}

}
