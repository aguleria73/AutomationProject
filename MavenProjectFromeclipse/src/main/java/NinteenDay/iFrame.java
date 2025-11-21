package NinteenDay;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class iFrame {
	
//	static FirefoxDriver driver;
	static ChromeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		
		framesInsideFrame();
		
	}
	
	public static void framesInsideFrame() throws InterruptedException {
		
//		String mainWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		// Frame one
		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[1]")));
		WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"id1\"]/div/input"));
		frame1.sendKeys("Frame one");

		// Frame Two
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frameset/frame[1]")));
		WebElement frame2 = driver.findElement(By.xpath("//input[@name='mytext2']"));
		frame2.sendKeys("Frame two");
		
		// Frame Three
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frameset/frame[2]")));
		WebElement frame3 = driver.findElement(By.xpath("//input[@name='mytext3']"));
		frame3.sendKeys("Frame 3");

		// Let's start with multiple choice.
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/center/iframe")));
		WebElement frame3MultipleChoice = driver.findElement(By.xpath("//*[@id=\"i12\"]/div[3]/div"));
		frame3MultipleChoice.click();
		WebElement frame3OtherInput = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[1]/div/span/div/div[3]/div/span/div/div/div[1]/input"));
		frame3OtherInput.sendKeys("Other");
		
		// How do you plan to use the software?
//		WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"i27\"]/div[2]"));
//		CheckBox.click();

		WebElement MultiCheckBox = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[1]"));
		List <WebElement> l1 = MultiCheckBox.findElements(By.tagName("label"));
//		/html[1]/body[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div["+i+"]/label[1]/div[1]/div[1]/div[2]
		for(int a=1; a<=l1.size(); a++) 
		{
			WebElement clickingMultiCheckBox = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div["+a+"]/label/div/div[2]"));
			System.out.println(a + ". " + "Start");
			System.out.println(a + ". CheckBox to be CLICK:- " + clickingMultiCheckBox.getText());
			clickingMultiCheckBox.click();
			System.out.println(a + ". " + "End");
			System.out.println(" ");
			Thread.sleep(2000);
		}
		
		// Did you know that the IDE has a LOOP button?
		WebElement choose = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[1]/div[1]"));
		choose.click();
		Thread.sleep(2000);
		String ChooseOptionsXpath = "//*[@id='mG61Hd']/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[2]/div[4]/span";
		WebElement ChooseOptions = driver.findElement(By.xpath(ChooseOptionsXpath));
		ChooseOptions.click();

		
		// Enter a short text
//		Thread.sleep(2000);
//		WebElement ShortText = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input"));
//		ShortText.sendKeys("aguleria73@gmail.com");
		
		// Enter a long answer
//		WebElement LongAnswer = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[1]/div[2]/textarea"));
//		LongAnswer.sendKeys("Password is password");
		
		
		// Frame Four
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frameset/frame[3]")));
//		WebElement frame4 = driver.findElement(By.xpath("//*[@id=\"id4\"]/div/input"));
//		frame4.sendKeys("Frame four");
		
		// Frame Five
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
//		WebElement frame5 = driver.findElement(By.xpath("//*[@id=\"id5\"]/div/input"));
//		frame5.sendKeys("Frame five");
		
		
		// Next Button
//		Thread.sleep(2000);
//		WebElement NextButton = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div[1]/div[3]/div[1]/div[1]/div"));
//		NextButton.click();
		
		
//		driver.switchTo().window(mainWindow);
	}
	
	
	
}
