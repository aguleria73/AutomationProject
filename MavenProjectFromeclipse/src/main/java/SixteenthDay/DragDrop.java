package SixteenthDay;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	static ChromeDriver driver;

	public static void main(String[] args) {
//		jqueryDrag();
		GlobalsqaDrag();

	}

	public static void jqueryDrag() {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions drag = new Actions(driver);
		drag.dragAndDrop(source, destination).build().perform();
	}

	public static void GlobalsqaDrag() {
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


		WebElement destination = driver.findElement(By.xpath("//*[@id=\"trash\"]"));
		List<WebElement> source = driver.findElements(By.xpath("//*[@id=\"gallery\"]/li"));

		Actions action = new Actions(driver);

		for (int i = 0; i < source.size(); i++) {
			action.dragAndDrop(source.get(i), destination).build().perform();
		}

		driver.switchTo().defaultContent();

		List<WebElement> popup = driver.findElements(By.xpath("//*[@id=\"dismiss-button\"]/div/span"));
		if (popup.size() > 0) {
			popup.get(0).click();
			System.out.println("Popup is closed");
		} else {
			System.out.println("Popup is not appears");
		}
	}

}
