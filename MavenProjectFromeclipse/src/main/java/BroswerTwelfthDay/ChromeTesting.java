package BroswerTwelfthDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTesting {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "/Library/Java/Driver/chromedriver");
//		ChromeDriver cd = new ChromeDriver();
//		cd.get("https://chatgpt.com/?model=auto");
		
		WebDriver wd1 = new ChromeDriver();
		wd1.get("https://chatgpt.com/?model=auto");
		System.out.println("Title1:- "+ wd1.getTitle());
		
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--start-maximized");
//		co.addArguments("--incognito");
//		ChromeDriver cd1 = new ChromeDriver(co);
//		WebDriver wd11 = new ChromeDriver(co);
//		cd1.get("https://chatgpt.com/?model=auto");
//		System.out.println("Title1:- "+ cd1.getTitle());
		
		
		
		
//		FirefoxOptions ffo = new FirefoxOptions();
//		ffo.addArguments("--private");
////		FirefoxDriver ffd = new FirefoxDriver(ffo);
//		WebDriver wd2 = new FirefoxDriver(ffo);
//		wd2.get("https://www.gmail.com/");
//		System.out.println("Title2:- "+ wd2.getTitle());
		
//		WebDriver wd3 = new SafariDriver();
//		wd3.get("https://www.chatgpt.com/");
//		System.out.println("Title3:- "+ wd3.getTitle());
		

	}

}
