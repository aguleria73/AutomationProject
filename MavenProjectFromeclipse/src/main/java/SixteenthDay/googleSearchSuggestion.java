package SixteenthDay;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleSearchSuggestion {

	static FirefoxDriver driver;

	public static void main(String[] args) {
		SearchSuggestion();

	}

	public static void SearchSuggestion() {

		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement staySignOut = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div[2]/div/promo-button-text[1]/div/div")));
		staySignOut.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Narendra Modi");

		WebElement suggestion = driver.findElement(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul"));
		List<WebElement> listofsuggestion = suggestion.findElements(By.tagName("li"));

		System.out.println("---- Suggesstion Data Start ----- ");
		for (int i = 1; i < listofsuggestion.size(); i++) {
			System.out.println(i + ". " + listofsuggestion.get(i).getText());
		}
		System.out.println("---- Suggesstion Data End ----- ");
		System.out.println("  ");

		System.out.println("---- Getting name form Suggesstion Data Start ----- ");
		for (int j = 1; j < listofsuggestion.size(); j++) {
			WebElement first = driver.findElement(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li[" + j + "]//span"));
			System.out.println(j + ". " + " " + first.getText());
		}
		System.out.println("---- Getting name form Suggesstion Data End ----- ");
		System.out.println("  ");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		search.sendKeys(Keys.ARROW_DOWN);
		search.sendKeys(Keys.ENTER);

	}

}