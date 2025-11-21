package FifteenDay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddingDataInElements {

	static ChromeDriver driver;
	static WebElement dropdown;
	static Select selection;
	static String contry;

	public static void main(String[] args) {
		DataFillGetData();
//		GettingDataFromDropdown();

	}

	public static void DataFillGetData() {

		driver = new ChromeDriver();
		driver.get("https://www.qtpselenium.com/contact-us");

		// First way to add data into the elements
//		WebElement we1 = Driver.findElement(By.id("userInputName"));
//		we1.sendKeys("Ashish Guleria");

		// Second way to add data into the elements
		driver.findElement(By.id("userInputName")).sendKeys("Ashish Guleria");
		driver.findElement(By.id("userEMailAddress")).sendKeys("aguleria73@gmail.com");
		driver.findElement(By.id("userContactNumber")).sendKeys("+91 9876543210");

		// For dropdown
//		dropdown = driver.findElement(By.id("userCountry"));
//		selection = new Select(dropdown);
//		s1.selectByVisibleText("India");
//		s1.selectByIndex(106);
//		s1.selectByValue("106");

//		String country = dropdown("Afghanistan");
		dropdown1("Zimbabwe");


		driver.findElement(By.id("userProvidedMessage")).sendKeys("I want to purchusing Automation course in Selenium Java");
		driver.findElement(By.id("CaptchaInput")).sendKeys("Vaild Captcha");

		String name = driver.findElement(By.id("userInputName")).getAttribute("value");
		String email = driver.findElement(By.id("userEMailAddress")).getAttribute("value");
		String phone = driver.findElement(By.id("userContactNumber")).getAttribute("value");
//		String country = selection.getFirstSelectedOption().getText();
		String message = driver.findElement(By.id("userProvidedMessage")).getAttribute("value");
		String captcha = driver.findElement(By.id("CaptchaInput")).getAttribute("value");

		System.out.println("Name:- " + name);
		System.out.println("Email:- " + email);
		System.out.println("Phone Number:- " + phone);
		System.out.println("Country:- " + contry);
		System.out.println("message:- " + message);
		System.out.println("captcha:- " + captcha);
	}

	

	public static void dropdown1(String Countryname) {
		dropdown = driver.findElement(By.id("userCountry"));
		selection = new Select(dropdown);
		selection.selectByVisibleText(Countryname);
		contry = selection.getFirstSelectedOption().getText();
//		System.out.println("Country:- "+contry);

	}

	public static void GettingDataFromDropdown() {
		driver = new ChromeDriver();
		driver.get("https://www.qtpselenium.com/contact-us");
		dropdown = driver.findElement(By.id("userCountry"));
		selection = new Select(dropdown);

		List<WebElement> l1 = selection.getOptions();
//		Dropdown.findElements(By.tagName("option")); 
		for (int countryvalue = 1; countryvalue < l1.size(); countryvalue++) {
			System.out.println(countryvalue + " -- " + l1.get(countryvalue).getText());
//			System.out.println(countryvalue);
		}

	}
	
	public static String dropdown(String Country) {
		dropdown = driver.findElement(By.id("userCountry"));
		selection = new Select(dropdown);
		selection.selectByVisibleText(Country);
		return selection.getFirstSelectedOption().getText();

	}
	
	
//	String selectCountry = "Afghanistan"; //Zimbabwe //Afghanistan
//	List<WebElement> list1 = s1.getOptions();
//	for (int i = 1; i <= list1.size(); i++) {
//		if (list1.get(i).getText().matches(selectCountry)) {
//			list1.get(i).click();
//			break;
//		}
//	}

}
