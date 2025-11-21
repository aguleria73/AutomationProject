package FifteenDay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class cosmocodeCountry {
	static ChromeDriver cdriver;

	public static void main(String[] args) {

		cdriver = new ChromeDriver();
//		countrylist();
		completeTable();
//		completeTable1();
//		countrylist2();
//		completeTable2();

	}

	public static void countrylist2() {
//		cdriver= new ChromeDriver();
		String mainWindow = cdriver.getWindowHandle(); // store main window
		cdriver.switchTo().newWindow(WindowType.TAB);
		cdriver.get("https://cosmocode.io/automation-practice-webtable/");
		WebElement table = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody"));
		List<WebElement> list1 = table.findElements(By.tagName("tr"));

		for (int a = 2; a <= list1.size(); a++) {
			WebElement country = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[" + a + "]/td[2]"));
			System.out.println(country.getText());
		}

		cdriver.close();
		cdriver.switchTo().window(mainWindow);

	}

	public static void completeTable2() {
//		cdriver = new ChromeDriver();
		String mainWindow = cdriver.getWindowHandle(); // store main window
		cdriver.switchTo().newWindow(WindowType.TAB);
		cdriver.get("https://cosmocode.io/automation-practice-webtable/");
		WebElement table = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody"));
		List<WebElement> list = table.findElements(By.tagName("tr"));

		for (int i=2; i<list.size(); i++) 
		{
			List<WebElement> list2 = list.get(i).findElements(By.tagName("td"));
			
			for (int j=2; j<=list2.size(); j++) 
			{
				WebElement table1 = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(table1.getText());
				System.out.println(" ");
			}
			System.out.println("----- " + "Row " + i + " -----");
			System.out.println(" ");
		}
		cdriver.close();
		cdriver.switchTo().window(mainWindow); // back to main window

	}

	public static void completeTable1() {

//		cdriver = new ChromeDriver();
		String mainWindow = cdriver.getWindowHandle(); // store main window
		cdriver.switchTo().newWindow(WindowType.TAB); // open new tab
		cdriver.get("https://cosmocode.io/automation-practice-webtable/");
		WebElement path = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody"));

		int a = 2;
		while (Xpathchecking("//*[@id=\"countries\"]/tbody/tr[" + a + "]")) {
//			WebElement data = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[" + a + "]"));
			List<WebElement> l2 = path.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr[" + a + "]/td"));
			System.out.print(a + ". ");
			System.out.println();
			System.out.println("County:- " + l2.get(1).getText());
			System.out.println("Capital(s):- " + l2.get(2).getText());
			System.out.println("Currency:- " + l2.get(3).getText());
			System.out.println("Primary Language(s):- " + l2.get(4).getText());
			System.out.println();
			System.out.println();
			a++;
		}
		System.out.println();
		cdriver.close();
		cdriver.switchTo().window(mainWindow); // back to main window

	}

	public static void completeTable() {

//		cdriver = new ChromeDriver();
		String mainWindow = cdriver.getWindowHandle(); // store main window
		cdriver.switchTo().newWindow(WindowType.TAB); // open new tab
		cdriver.get("https://cosmocode.io/automation-practice-webtable/");

		WebElement path = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody"));
//		List<WebElement> list = path.findElements(By.tagName("td"));

		int a = 2;
		while (Xpathchecking("//*[@id=\"countries\"]/tbody/tr[" + a + "]")) {
			WebElement data = path.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[" + a + "]"));
			System.out.print(a + ". " + data.getText());
			System.out.println();
			System.out.println();
			a++;
		}
		System.out.println();
		cdriver.close();
		cdriver.switchTo().window(mainWindow); // back to main window

	}

	public static void countrylist() {
//		cdriver = new ChromeDriver();
		String mainWindow = cdriver.getWindowHandle(); // store main window
		cdriver.switchTo().newWindow(WindowType.TAB); // open new tab
		cdriver.get("https://cosmocode.io/automation-practice-webtable/");

//		WebElement countryPath = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[2]"));
//		List<WebElement> countrytag = countryPath.findElements(By.tagName("td"));

		int list = 2;
		while (Xpathchecking("//*[@id=\"countries\"]/tbody/tr[" + list + "]/td[2]")) {
			WebElement countrylist = cdriver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[" + list + "]/td[2]"));
			System.out.println(list + ".  " + countrylist.getText());
			list++;
		}
		cdriver.close();
		cdriver.switchTo().window(mainWindow); // back to main window
	}

	public static boolean Xpathchecking(String xpaths) {
		int check = cdriver.findElements(By.xpath(xpaths)).size();
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

}
