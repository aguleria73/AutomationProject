package EighteenDay;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmericanGolfClub {

	static FirefoxDriver driver;
	
	public static void main(String[] args) {
		GolfClub();

	}
	
	public static void GolfClub() {
		driver = new FirefoxDriver();
		driver.get("https://www.americangolf.co.uk/en/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div/div[2]/button[2]")));
		CookiesPopup();
		
		Actions action = new Actions(driver);
		
		String GolfClubXpath = "//*[@id=\"header-container\"]/div[2]/header/div[3]/ul/div[3]/li";
		
		WebElement GolfClubButton = driver.findElement(By.xpath(GolfClubXpath));
		action.moveToElement(GolfClubButton).build().perform();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		"//a[@href='/golf-clubs/putters/shop-by/gender/mens/']";
//		*[@id="header-container"]/div[2]/header/div[3]/ul/div[3]/div/div/div/div[1]/div[1]/ul/li[6]/a
		String MensPutterXpath = "//a[@href='/golf-clubs/putters/shop-by/gender/mens/']";
		WebElement MensPutterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MensPutterXpath)));
		MensPutterButton.click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div/div[2]/button[2]")));
		
		CookiesPopup();
		
		String MensPutterTextInNavigatedPage ="/html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/div[2]/h1";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MensPutterTextInNavigatedPage)));
		
		CookiesPopup();
		
		// Checking Text in navigated page:- Correct or not
		String MensPutterText = "/html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/div[2]/h1";
		WebElement GetText = driver.findElement(By.xpath(MensPutterText));
		System.out.println(GetText.getText());
		String StaticText ="MENS GOLF PUTTERS";
		
		if(GetText.getText().equals(StaticText)) 
		{
			System.out.println("Right page");
			
			showmore();
			System.out.println(" ");

			BrandName();
			System.out.println(" ");

			ClickingOnBrandNameCheckBox("TAYLORMADE");
			System.out.println(" ");
			
		} else 
		{
			System.out.println("Incorrect page");
		}
		
		// Check for show more button
//		showmore();
//		String ShowMoreButtonXpath = "//*[@id=\"headlessui-disclosure-panel-:rs:\"]/div/button";
//		if(ShowMoreButton(ShowMoreButtonXpath))
//		{
//			driver.findElement(By.xpath(ShowMoreButtonXpath)).click();
//			System.out.println("Show more button is display & Clicked");
//		}else 
//		{
//			System.out.println("Show more button is not display");
//		}
		
//		System.out.println(" ");
		
		// Fetching Brand name
//		BrandName();
//		System.out.println(" ");
		
		// Clicking on checkBox of brand name
//		ClickingOnBrandNameCheckBox("TAYLORMADE");
//		System.out.println(" ");
//		driver.quit();
//		driver.close();
		
		
	}
	
	public static void ClickingOnBrandNameCheckBox(String NameOfBrand) {
		
		WebElement XpathOfCompleteBrand = driver.findElement(By.xpath("//*[@id=\"headlessui-disclosure-panel-:rs:\"]/div/ul"));
		List<WebElement> list = XpathOfCompleteBrand.findElements(By.tagName("li"));
		for(int i=1; i<list.size(); i++) 
		{
			System.out.println(" ");
			System.out.println(" ---- Finding Brand name to check START ----- ");
//			System.out.println(" ");
			String XpathOfParticularBrandNameXpath = "//*[@id=\"headlessui-disclosure-panel-:rs:\"]/div/ul/li["+i+"]/label/span";
			WebElement ParticularBrandName = driver.findElement(By.xpath(XpathOfParticularBrandNameXpath));
			if(ParticularBrandName.getText().equals(NameOfBrand)) 
			{
				driver.findElement(By.xpath(XpathOfParticularBrandNameXpath)).click();
				System.out.println(i + ". " + "Clicked on check box");
				break;
			}else 
			{
				System.out.println(i+". " +"Try to click:- Brand Name not found");
			}

		}
		System.out.println(" ");
		System.out.println(" ---- Finding Brand name to check END ----- ");

	}
	
	public static void BrandName() {
		WebElement Brand = driver.findElement(By.xpath("//*[@id=\"headlessui-disclosure-panel-:rs:\"]/div/ul"));
		List<WebElement> list1 = Brand.findElements(By.tagName("li"));
		
		System.out.println("----- Brand Names Start -----");
		for(int i=1; i<=list1.size(); i++) 
		{
			WebElement BrandName = driver.findElement(By.xpath("//*[@id=\"headlessui-disclosure-panel-:rs:\"]/div/ul/li["+i+"]/label/span"));
			System.out.println(i+". "+ BrandName.getText());
		}
		System.out.println("----- Brand Names End -----");
		
	}

	
	public static void showmore() {
		
		String ShowMoreButtonXpath = "//*[@id=\"headlessui-disclosure-panel-:rs:\"]/div/button";
		if(ShowMoreButton(ShowMoreButtonXpath))
		{
			driver.findElement(By.xpath(ShowMoreButtonXpath)).click();
			System.out.println("Show more button is display & Clicked");
		}else 
		{
			System.out.println("Show more button is not display");
		}
	}
	
	
	public static boolean ShowMoreButton(String ShowMoreButton) {

		int size = driver.findElements(By.xpath(ShowMoreButton)).size();
		if (size > 0) 
		{
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void CookiesPopup() {
		
		List<WebElement> AcceptButton = driver.findElements(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div/div[2]/button[2]"));
		
		if(!AcceptButton.isEmpty()) 
		{
			AcceptButton.get(0).click();
			System.out.println("Clicked on cookies accept button");
		}else 
		{
			System.out.println("Cookies modal is not display");
		}
	}
	
}
