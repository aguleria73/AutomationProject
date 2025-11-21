package Twentiethday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cricbuzz {

	static FirefoxDriver driver;
//	static ChromeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		LatestNews();
		
//		String Name = "Ashish";
//		String n = new StringBuilder(Name).reverse().toString();
//		System.out.println("Name:- "+ n);
		
	}
	
	public static void LatestNews() throws InterruptedException {
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.cricbuzz.com/");
//		Thread.sleep(500);
		
		Actions action = new Actions(driver); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String MoreNewsButtonXpath = "/html/body/div[1]/div[2]/div[6]/div[1]/div/div[11]/a";
		WebElement MoreNewsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MoreNewsButtonXpath)));
//		WebElement MoreNewsButton = driver.findElement(By.xpath(MoreNewsButtonXpath));
		action.moveToElement(MoreNewsButton).build().perform();
//		action.keyDown(MoreNewsButton, Keys.CONTROL).perform();
		MoreNewsButton.click();
		
		String LatestCricketNewsText = "Latest Cricket News";
		String LatestCricketNewsTextXpath = "//*[@id='page-wrapper']/div[5]/div[1]/h1";
		WebElement LatestCricketNewsTextForMatching = driver.findElement(By.xpath(LatestCricketNewsTextXpath));
		if(LatestCricketNewsTextForMatching.getText().equals(LatestCricketNewsText)) 
		{
			System.out.println("We navigate to the 'Latest cricket news' page");
		}else 
		{
			System.out.println("We navigate to the 'Incorrect page' ");
		}
		
		System.out.println(" ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-wrapper']/div[5]/div[1]/h1")));
		
		WebElement LatestNewsXpath = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[5]/div[1]"));
		List<WebElement> list1 = LatestNewsXpath.findElements(By.tagName("div"));
		for(int i=1; i<=list1.size(); i++) 
		{
			WebElement GettingDataFromLatestNews = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[5]/div[1]/div[2]/div["+i+"]"));
			action.moveToElement(GettingDataFromLatestNews).build().perform();
			System.out.println(i+". ");
			System.out.println(GettingDataFromLatestNews.getText());
			System.out.println(" ");
			System.out.println(" ");
//			Thread.sleep(200);
		}
			
		
	}
}
