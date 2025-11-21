package ThirteenDay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebelementsbyTag {

	public static void main(String[] args) {
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.qtpselenium.com/contact-us");

		List<WebElement> l1 = cd.findElements(By.tagName("input"));
//		System.out.println(l1.size());

		for (int a = 0; a < l1.size(); a++) {
			System.out.println(a + " " + l1.get(a).getText() + " --- " + l1.get(a).isDisplayed() + " ---- "
					+ l1.get(a).getAttribute("name"));
		}

	}

}
