package ThirteenDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	WebDriver driver;

	public static void main(String[] args) {
		
	}

	public void launchbroser(String broswername) {
		if (broswername.equals("Chrome")) {
			driver = new ChromeDriver();

		} else if (broswername.equals("FireFox")) {
			driver = new FirefoxDriver();
		}

	}

	public void openURL(String URL) {
		driver.get(URL);
	}

	

}
