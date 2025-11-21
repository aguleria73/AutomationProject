package FourteenthDay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gettingElementsbyXpath {
	
	
	public static void main(String[] args) {
//		header();
//		headernew();
//		rightsection();
//		Sportheading();
//		testing();
//		Sportheadingfir();
	}
	
	public static void Sportheading() {
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.bbc.com/");
		
		WebElement we = cd.findElement(By.xpath("//*[@id=\"main-content\"]/article/section[8]/div/div/div[2]/div[2]/div[2]"));
		List<WebElement> lwe = we.findElements(By.tagName("h2"));

		for (int spheading = 1; spheading <= lwe.size(); spheading++) {
//			WebElement we1 = cd.findElement(By.xpath("//*[@id=\"main-content\"]/article/section[8]/div/div/div[2]/div[2]/div[2]/div["+spheading+"]/div/a/div"));
			WebElement we1 = cd.findElement(By.xpath("//*[@id=\"main-content\"]/article/section[8]/div/div/div[2]/div[2]/div[2]/div["+spheading+"]//h2"));
			
			//*[@id="main-content"]/article/section[8]/div/div/div[2]/div[2]/div[2]/div[1]/div/a/div/div[2]/div/div/h2
			//*[@id="main-content"]/article/section[8]/div/div/div[2]/div[2]/div[2]/div[2]/div/a/div/div/div/h2
			//*[@id="main-content"]/article/section[8]/div/div/div[2]/div[2]/div[2]/div[3]/div/a/div/div/div/h2
			//*[@id="main-content"]/article/section[8]/div/div/div[2]/div[2]/div[2]/div[4]/div/a/div/div/div/h2
	
			System.out.println(spheading + " -- > " + we1.getText());
			System.out.println(" ");
			System.out.println(" ");
		}

	}
	
	public static void rightsection() {
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.bbc.com/");

		WebElement we = cd.findElement(By.xpath("//*[@id=\"main-content\"]/article/section[1]/div/div/div[2]"));
		//*[@id="main-content"]/article/section[1]/div/div/div[2]/div[1]/div/a/div/div/p
		List<WebElement> lwe = we.findElements(By.tagName("h2")); // take unique tag
		
		for (int right = 1; right <= lwe.size(); right++) {
			WebElement we1 = cd.findElement(By.xpath(
					"//*[@id=\"main-content\"]/article/section[1]/div/div/div[2]/div[" + right + "]/div/a/div/div/h2"));
			//*[@id="main-content"]/article/section[1]/div/div/div[2]/div[1]/div/a/div/div/div[1]/div/h2
			//*[@id="main-content"]/article/section[1]/div/div/div[2]/div[1]/div/a/div/div/p
			// *[@id="main-content"]/article/section[1]/div/div/div[2]/div[1]/div/a/div/div/p
			System.out.println(right + " -- > " + we1.getText());
			System.out.println(" ");
			System.out.println(" ");
		}

	}
	
	public static void headernew() {
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.bbc.com/");
		
//		WebElement we = cd.findElement(By.xpath("/html/body/div[2]/div/nav/section/nav/ul"));
//		WebElement we = cd.findElement(By.xpath("//*[@id=\"main-navigation-container\"]/section/nav/ul"));
		WebElement we = cd.findElement(By.xpath("//*[@ id =\"__next\"]/div/nav/section/nav/ul"));
		List<WebElement> l1 = we.findElements(By.tagName("li"));
		
		for(int header =1; header<=l1.size();header++) 
		{
//			WebElement we1 = cd.findElement(By.xpath("/html/body/div[2]/div/nav/section/nav/ul/li[2]"));
			WebElement we1 = cd.findElement(By.xpath("//*[@ id =\"__next\"]/div/nav/section/nav/ul/li["+header+"]"));
			System.out.println(we1.getText());
		}
		
		cd.quit();
	}	
	
	
	public static void header() {
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.bbc.com/");
		
//		WebElement we = cd.findElement(By.xpath("/html/body/div[2]/div/nav/section/nav/ul"));
		WebElement we = cd.findElement(By.xpath("//*[@id=\"main-navigation-container\"]/section/nav/ul"));
		List<WebElement> l1 = we.findElements(By.tagName("li"));
		
		for(int header =0; header<l1.size();header++) 
		{
			System.out.println(l1.get(header).getText() + " --> " + l1.get(header).getAttribute("class"));
		}
		
		cd.quit();
	}	
	
	
	
	public static void Sportheadingfir() {
		FirefoxDriver cd = new FirefoxDriver();
		cd.get("https://www.bbc.com/");
		
		WebElement we = cd.findElement(By.xpath("//*[@id=\"main-content\"]/article/section[8]/div/div/div[2]/div[2]/div[2]"));
		List<WebElement> lwe = we.findElements(By.tagName("h2"));
		for (int spheading = 1; spheading <= lwe.size(); spheading++) {
			WebElement we1 = cd.findElement(By.xpath("//*[@id=\"main-content\"]/article/section[8]/div/div/div[2]/div[2]/div[2]/div["+spheading+"]//h2"));
			System.out.println(spheading + " -- > " + we1.getText());
			System.out.println(" ");
			System.out.println(" ");
		}

	}
	
	
	

}
