package EighteenDay;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {

	static FirefoxDriver driver;
	
	public static void main(String[] args) {

		try {
			driver = new FirefoxDriver();
//			driver.get("https://google.com");
			JsAlert();
			JsConfirm();
			JsPrompt();
		} 
		catch (Exception e) 
		{
			System.out.println("Error:- " + e);
		}
		
	}

	
	public static void JsAlert() throws InterruptedException {
//		driver = new FirefoxDriver();
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ClickForJSAlertButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		ClickForJSAlertButton.click();
		Alert jsAlert = driver.switchTo().alert();
		String jsalertMessage = jsAlert.getText();
		System.out.println(jsalertMessage);
		Thread.sleep(3000);
		jsAlert.accept();
		if(driver.getPageSource().contains("You successfully clicked an alert")) 
		{
			System.out.println("Successfully click on OK Button");
		}else 
		{
			System.out.println("Text is not Contains");
		}
//		driver.close();
		driver.switchTo().window(mainWindow);
		
		
	}

	public static void JsConfirm() throws InterruptedException {
//		driver = new FirefoxDriver();
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ClickForJSConfirmButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		ClickForJSConfirmButton.click();
		Alert jsConfirmAlert = driver.switchTo().alert();
		String jsConfirmAlertMessage = jsConfirmAlert.getText();
		System.out.println(jsConfirmAlertMessage);
		Thread.sleep(2000);
//		jsConfirmAlert.accept();
		jsConfirmAlert.dismiss();
		if(driver.getPageSource().contains("You clicked: Cancel"))
		{
			System.out.println("Successfuly click on CANCEL Button");
		}
		else if(driver.getPageSource().contains("You clicked: Ok"))
		{
			System.out.println("Successfully click on OK Button");
		}
//		driver.close();
		driver.switchTo().window(mainWindow);
		
	}

	public static void JsPrompt() throws InterruptedException {
//		driver = new FirefoxDriver();
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ClickForJSPromptButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		ClickForJSPromptButton.click();
		Alert JsPromptAlert = driver.switchTo().alert();
		String JsPromptAlertMessage = JsPromptAlert.getText();
		JsPromptAlert.sendKeys("Ashish Guleria");
		System.out.println(JsPromptAlertMessage);
		Thread.sleep(1500);
//		JsPromptAlert.accept();
		JsPromptAlert.dismiss();
		if(driver.getPageSource().contains("You entered: Ashish Guleria")) 
		{
			System.out.println("Successfuly click on OK button");
		}
		else
		{
			if (driver.getPageSource().contains("You entered: null")) 
			{
				System.out.println("Successfuly click on CANCEL button");
			}
			
		}
//		driver.close();
		driver.switchTo().window(mainWindow);
		
	}
}
