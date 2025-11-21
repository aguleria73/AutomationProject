package FifteenDay;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Bbcnews {
	static FirefoxDriver driver;

	public static void main(String[] args) {
		bbcRight();

	}
	public static void bbcRight() {
		driver = new FirefoxDriver();
		driver.get("https://www.bbc.com/");
		
		int print =1;
		while (BbcIsElement("//*[@id=\"main-content\"]/article/section[1]/div/div/div[2]/div["+print+"]/div/a/div/div/div[1]/div/h2")) 
		{
			WebElement web1 = driver.findElement(By.xpath("//*[@id=\"main-content\"]/article/section[1]/div/div/div[2]/div["+print+"]/div/a/div/div/div[1]/div/h2"));
			System.out.println(web1.getText());
			System.out.println("  ");
			print++;
		}
	
	}

	public static boolean BbcIsElement(String xpath) {
		int elements = driver.findElements(By.xpath(xpath)).size();

		if (elements > 0) {
			return true;
		} else {
			return false;
		}

	}

}
