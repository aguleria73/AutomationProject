package ThirteenDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicBroswer {

	public static void main(String[] args) {
		String Broswer = "FireFox";

		WebDriver driver = null;

		if (Broswer.equals("Chrome")) {
//			ChromeDriver cd = new ChromeDriver();
			driver = new ChromeDriver();
//			driver.get("https://www.linkedin.com/uas/login?fromSignIn=true&session_redirect=%2Fflagship-web%2Fmynetwork%2Fgrow%2F");
		} else if (Broswer.equals("FireFox")) {
//			FirefoxDriver ffd = new FirefoxDriver();
			driver = new FirefoxDriver();
//			driver.get("https://secure.indeed.com/auth?hl=en_IN&co=IN&continue=https%3A%2F%2Fin.indeed.com%2F&tmpl=desktop&from=gnav-util-homepage&jsContinue=https%3A%2F%2Fprofile.indeed.com%2Fwelcome%3Fhl%3Den_IN%26co%3DIN%26from%3Dgnav-homepage%26continue%3Dhttps%253A%252F%252Fonboarding.indeed.com%252Fonboarding%253Fhl%253Den_IN%2526co%253DIN%2526from%253Dgnav-homepage&empContinue=https%3A%2F%2Faccount.indeed.com%2Fmyaccess");
		}

		driver.get(
				"https://www.linkedin.com/uas/login?fromSignIn=true&session_redirect=%2Fflagship-web%2Fmynetwork%2Fgrow%2F");
		System.out.println(driver.getTitle());
	}

}
