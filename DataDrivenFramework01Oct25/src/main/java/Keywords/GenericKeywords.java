package Keywords;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Reports.ExtentManager;



public class GenericKeywords {
	public WebDriver driver = null;
	public Properties prop;
	public Properties envProp;
	public ExtentTest test;
	public SoftAssert softAssert;
	
	
	public void openBrowser(String browserName) {
		if(browserName.equals("Chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FireFox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Safari")) 
		{
			driver = new SafariDriver();
		}
	}
	
	
	public void openExistingBrowser(String browserName) {
		
		test.log(Status.INFO, "Opening Existing browser:- " + browserName);
		if (browserName.equals("Chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("debuggerAddress", "127.0.0.1:1992");
			driver = new ChromeDriver(options);
			driver.switchTo().newWindow(WindowType.TAB);
		} 
		else if (browserName.equals("FireFox")) 
		{
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("Safari")) 
		{
			driver = new SafariDriver();
		}

	}
	
	public void navigates(String URL) {
		test.log(Status.INFO, "Opening URL is:- "+URL);
//		driver.get(URL);
		driver.get(envProp.getProperty(URL));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void click(String locatorKey) {
		test.log(Status.INFO, "Clicking on:- "+ locatorKey);
//		driver.findElement(By.xpath(locatorKey)).click();
		getElement(locatorKey).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void clearText(String locatorKey) {
		test.log(Status.INFO, "Clearing Text on:- "+ locatorKey);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath(locatorKey)).clear();
//		getElement(locatorKey).clear();
		
		WebElement clearElement = getElement(locatorKey);
		clearElement.sendKeys(Keys.COMMAND+ "a");
		clearElement.sendKeys(Keys.DELETE);
		
	}
	
	public void type(String locatorKey, String enterData) throws InterruptedException {
		test.log(Status.INFO, "Typing on:- "+ locatorKey);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath(locatorKey)).sendKeys(enterData);
//		getElement(locatorKey).sendKeys(enterData);
		getElement(locatorKey).sendKeys(enterData);
		Thread.sleep(1000);
		
	}
	
	public void select(String locatorKey, String selectData) {
		test.log(Status.INFO, "Selecting :- "+ locatorKey + " " + "Selected Data " + selectData);
//		WebElement dropdown = getElement(locatorKey);
//		Select select = new Select(dropdown);
//		select.selectByVisibleText(selectData);
//		
		WebElement e1 = getElement(locatorKey);
		e1.sendKeys(selectData);
		e1.click();
	}
	
	
	public String getText (String locatorKey) {
		String gettingText = getElement(locatorKey).getText();
		return gettingText;
	}
	
	public WebElement getElement(String locatorKey) {
		
		// Check the presence
		// Check the visibility
		if(!isElementPresent(locatorKey))
		{
			// report failure
		}
		if(!isElementVisible(locatorKey)) 
		{
			// report failure
		}
		WebElement element = driver.findElement(getLocatorKey(locatorKey));
		return element;
		
	}
	
	public boolean isElementVisible(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorKey(locatorKey)));
			
		} 
		catch (Exception e) 
		{
			System.out.println("Error in isElementVisible function:- " + e);
			return false;
		}
		
		return true;
	}
	
	public boolean isElementPresent(String locatorKey) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocatorKey(locatorKey)));
		} 
		catch (Exception e) 
		{
			System.out.println("Error in isElementPresent function:- " + e);
			return false;
		}
		return true;
	}
	
	public void moveToElements(String locatorKey) {
		test.log(Status.INFO, "Moved to element" + locatorKey);
		try 
		{
//			Thread.sleep(2000);
			WebElement moveElement = driver.findElement(getLocatorKey(locatorKey));
			Actions action = new Actions(driver);
			action.moveToElement(moveElement).build().perform();
			Thread.sleep(1000);
		} catch (Exception e) 
		{
			System.out.println("Error in moveToElements function:- " + e);
		}
		
		
//		return moveElement;
	}
	
	public By getLocatorKey(String locatorKey) {
		By byLocator = null;
		
		if(locatorKey.endsWith("_xpath")) 
		{
			byLocator = By.xpath(envProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_id")) 
		{
			byLocator = By.id(envProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name")) 
		{
			byLocator = By.name(envProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_className")) 
		{
			byLocator = By.className(envProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_cssSelector")) 
		{
			byLocator = By.cssSelector(envProp.getProperty(locatorKey));
		}
		return byLocator;
		
	}
	
	public void reportFailure(String failureMsg, boolean stopOnFailure) 
	{
		System.out.println(failureMsg);
		test.log(Status.FAIL, failureMsg); // fail in extent report
		softAssert.fail(); // fail in testNG
		if(stopOnFailure) 
		{
			assertAll();
		}
	}
	
	public void assertAll() 
	{
		softAssert.assertAll();
	}
	
	public void takeScreenShot() 
	{
		Date date = new Date();
		String screenshotFile = date.toString().replaceAll(" ", "_").replaceAll(":", " ")+ ".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(scrFile, new File(ExtentManager.screenshotFolderPath + "/" + screenshotFile));
			test.log(Status.INFO, "Screenshot: "+test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + screenshotFile));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void quit() 
	{
		driver.quit();
	}

}
