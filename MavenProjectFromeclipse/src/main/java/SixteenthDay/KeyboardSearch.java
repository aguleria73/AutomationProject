package SixteenthDay;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class KeyboardSearch {

	static FirefoxDriver driver;

	public static void main(String[] args) {

//		search();
		AmericanSiteSearch();
	}

	public static void AmericanSiteSearch() {
		driver = new FirefoxDriver();
		driver.get("https://www.americangolf.co.uk/en/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebDriverWait waitForCookiesAcceptButton = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// Wait for cookies popup
		waitForCookiesAcceptButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div/div[2]/button[2]")));
		CookiesPopup();
		
		WebElement SearchField = driver.findElement(By.id("autocomplete-0-input"));
		SearchField.click();
		String EnterDataInSearch = "socks";
		SearchField.sendKeys(EnterDataInSearch);
		SearchField.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		CookiesPopup();
		
		String SearchTextXpath = "/html/body/div[3]/div[2]/div/div/div/div[1]/div/div[2]/h1";
		waitForCookiesAcceptButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchTextXpath)));
		WebElement SearchTextXpathResult = driver.findElement(By.xpath(SearchTextXpath));
		String SearchResultText = "SEARCH RESULTS - " + EnterDataInSearch.toUpperCase();
		if(SearchTextXpathResult.getText().equals(SearchResultText)) 
		{
			System.out.println("On same correct page");
			
			String ShowMoreXpath = "//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/button";
			String ClickOnBrandCheckbox = "NIKE GOLF";
			if(ShowMoreButton(ShowMoreXpath)) 
			{
				System.out.println("Show more button is displaying");
				driver.findElement(By.xpath(ShowMoreXpath)).click();
				SelectBrandNameWithForLoop(ClickOnBrandCheckbox);
				SelectBrandNameWithForLoop("FOOTJOY");
				SelectBrandNameWithForLoop("NIKON");
				SelectBrandNameWithForLoop("STROMBERG");
				System.out.println("Click on check box:- In IF");
			}
			else 
			{
				System.out.println("Show more button is not showing");
				SelectBrandNameWithForLoop(ClickOnBrandCheckbox);
				SelectBrandNameWithForLoop("PUMA GOLF");
				SelectBrandNameWithForLoop("PING");
				SelectBrandNameWithForLoop("FOOTJOY");
				System.out.println("Click on check box:-  In ELSE");
			}
		}
	}
	
	public static void SelectBrandNameWithWhile(String BrandName) {
		int i=1;
		while(ShowMoreButton("//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/ul/li["+i+"]")) 
		{
			System.out.println(i+ " While");
			String ParticularBrandNameXpath = "//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/ul/li["+i+"]/label/span[1]";
			WebElement AllBrandNameXpath = driver.findElement(By.xpath(ParticularBrandNameXpath));
//			System.out.println(i+". "+AllBrandNameXpath.getText());
			if(AllBrandNameXpath.getText().equals(BrandName))
			{
				driver.findElement(By.xpath(ParticularBrandNameXpath)).click();
				System.out.println(i+ " If");
			}
			i++;
		}
	}
	
	public static void SelectBrandNameWithForLoop(String BrandName) {
	
		List<WebElement> fd = driver.findElements(By.xpath("//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/ul/li"));
		for(int a=1; a<fd.size(); a++) 
		{
			System.out.println(a+ " FOR");
			String ParticularBrandNameXpath = "//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/ul/li["+a+"]/label/span[1]";
			WebElement Allbrand = driver.findElement(By.xpath(ParticularBrandNameXpath));
			if(Allbrand.getText().equals(BrandName)) 
			{
				driver.findElement(By.xpath(ParticularBrandNameXpath)).click();
				System.out.println(a+ " IF");
				break;
			}
			
		}

	}
	
	public static boolean ShowMoreButton(String xpath) {
		
		int size = driver.findElements(By.xpath(xpath)).size();
		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void CookiesPopup() {
		
		List <WebElement> CookiesAcceptButton = driver.findElements(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div/div[2]/button[2]"));
		if(!CookiesAcceptButton.isEmpty()) 
		{
			CookiesAcceptButton.get(0).click();
			System.out.println("Cookies popup is displaying & Accept");
		}else
		{
			System.out.println("Cookies popup is not showing");
		}
	}
	
	
	public static void search() {
		driver = new FirefoxDriver();
		driver.get("https://www.americangolf.co.uk/en/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement search = driver.findElement(By.xpath("//*[@id=\"autocomplete-0-input\"]"));
		search.sendKeys("golf");
		search.sendKeys(Keys.ENTER);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div/div[2]/button[2]")));
		WebElement accept = driver.findElement(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div/div[2]/button[2]"));
		accept.click();

		// Wait for Search results - Enter_text_name
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[1]/div/div[2]/h1")));
		
		// Wait for Show more button
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-button-:rh:\"]/div/p")));
		List<WebElement> showmoreClick = driver.findElements(By.xpath("//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/button"));
		if (!showmoreClick.isEmpty()) {
			showmoreClick.get(0).click();
	        System.out.println("Clicked on Show More button.");
	    } else {
	        System.out.println("Show More button not present.");
	    }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Getting the name of brand
//		WebElement brandList = driver.findElement(By.xpath("//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/ul"));
//		List<WebElement> l1 = brandList.findElements(By.tagName("li"));
//		for (int i=1; i<=l1.size(); i++) 
//		{
//			WebElement brandName = driver.findElement(	By.xpath("//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/ul/li[" + i + "]/label/span[1]"));
//			System.out.println(i+". " + brandName.getText());
//		}
		System.out.println("-------- ---------- -------");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
//		WebElement CollapseText = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/button")));
//		CollapseText.click();
//		
//		WebElement minusButton = driver.findElement(By.xpath("//*[@id=\"headlessui-disclosure-button-:rh:\"]/div/div/p"));
//		minusButton.click();
		
//		WebElement checkClick = driver.findElement(By.xpath("//*[@id=\"headlessui-disclosure-panel-:ri:\"]/div/ul"));
//		String[] name = {"UNDER ARMOUR","PUMA GOLF"};
//		List<WebElement> tag = checkClick.findElements(By.tagName("input"));
		
	}
	
	
}
