package NinteenDay;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PaytmLoginFrame {

	static FirefoxDriver driver;

	public static void main(String[] args) {
		
		driver = new FirefoxDriver();

		PaytmLogin();
		
	}
	
	public static void PaytmLogin() {
	
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://paytm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div[2]/div[2]/div"));
		LoginButton.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String frameXpathMain = "//*[@id=\"app\"]/header/div/div[2]/div[2]/div[2]/div[2]/div/iframe";
		driver.switchTo().frame(driver.findElement(By.xpath(frameXpathMain)));
		
		String frameXpathSub = "//*[@id=\"oauth-iframe\"]";
		driver.switchTo().frame(driver.findElement(By.xpath(frameXpathSub)));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement point1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/ul/li[1]/span[2]"));
		System.out.println("1. " + point1.getText());
		
		
		WebElement point3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/ul/li[3]/span[2]"));
		System.out.println("3. "+ point3.getText());
		
		
		System.out.println("   ");
		System.out.println("With FOR Loop");
		
		//*[@id="app"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/ul/li[2]
		//*[@id="app"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/ul/li[3]
		WebElement StepsToScanQRCode = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/ul"));
		List<WebElement> liTags = StepsToScanQRCode.findElements(By.tagName("li"));
		for(int i=1; i<=liTags.size(); i++) 
		{
			WebElement AllText = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/ul/li["+i+"]"));
			System.out.println(AllText.getText());
			System.out.println(" ");
			
		}
		
	}
	

}
