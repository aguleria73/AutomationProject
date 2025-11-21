package NinteenDay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class MultipleDragAndDrop {

	static FirefoxDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		
//		PhotoManagerMultiDragAndDrop();
		AcceptedElements();

	}
	
	public static void PhotoManagerMultiDragAndDrop() throws InterruptedException {
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe")));
		
		int a =1;
		while(ImgMove("//*[@id='gallery']/li[1]")) 
		{
			WebElement sourceMainSub = driver.findElement(By.xpath("//*[@id='gallery']/li["+a+"]"));
			WebElement trash = driver.findElement(By.xpath("//*[@id=\"trash\"]"));
			action.dragAndDrop(sourceMainSub, trash).build().perform();
			Thread.sleep(2000);
		}
		
	}
	
	public static boolean ImgMove(String SourceMain ) {
		
		int size = driver.findElements(By.xpath(SourceMain)).size();
		if(size>0) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	
	}
	
	
	public static boolean ShowMoreButton(String xpath) {

		int size = driver.findElements(By.xpath(xpath)).size();
		if (size > 0) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
	
	public static void AcceptedElements() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		WebElement AcceptedElementsButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/ul/li[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(AcceptedElementsButton).build().perform();
		AcceptedElementsButton.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='post-2669']/div[2]/div/div/div[2]/p/iframe")));
		WebElement Dragable = driver.findElement(By.id("draggable"));
		WebElement Dropable = driver.findElement(By.id("droppable"));
		action.dragAndDrop(Dragable, Dropable).build().perform();
		
	}
	
	

}
