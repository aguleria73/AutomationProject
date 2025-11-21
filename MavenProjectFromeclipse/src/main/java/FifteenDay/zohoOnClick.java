package FifteenDay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zohoOnClick {
	static ChromeDriver cd;
	static WebDriverWait waitforPass;
	
	
	public static void main(String[] args) {
//		Login();
//		SignUp();
		SingUpErrorMessage();
	}
	
	
	public static void SignUp() {
		cd = new ChromeDriver();
		cd.get("https://www.zoho.com/");
		WebElement clickcheckbox = cd.findElement(By.xpath("//a[normalize-space()='Sign Up']"));
		clickcheckbox.click();
		
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		cd.findElement(By.id("email")).sendKeys("aguleria7@gmail.com");
		cd.findElement(By.id("password")).sendKeys("Aguler@342");
		cd.findElement(By.id("rmobile")).sendKeys("9876543210");
		cd.findElement(By.xpath("//*[@id=\"signupform\"]/div/div[2]/div/button")).click();
		WebElement check = cd.findElement(By.id("signup-termservice"));
		check.click();
		
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String email = cd.findElement(By.id("email")).getAttribute("value");
		String password = cd.findElement(By.id("password")).getAttribute("value");
		WebElement countrycode = cd.findElement(By.xpath("//*[@id=\"signupform\"]/div/div[3]/div/div/input[1]"));
		String code = countrycode.getAttribute("value");
		String mobile = cd.findElement(By.id("rmobile")).getAttribute("value");
		
		
		System.out.println("Email:- " + email);
		System.out.println("Password:- " + password);
		System.out.println("Mobile:- " + code + " " + mobile );
		
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		cd.findElement(By.id("signupbtn")).click();
		
	}
	
	public static void Login() {
		cd = new ChromeDriver();
		cd.get("https://www.zoho.com/");
		
		WebElement sign_in = cd.findElement(By.xpath("//a[@class='zgh-login'][normalize-space()='Sign In']"));
		sign_in.click();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		cd.findElement(By.id("login_id")).sendKeys("seleniumtraining10@gmail.com");
		cd.findElement(By.xpath("//button[@id='nextbtn']")).click();
//		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Explicit wait
		waitforPass = new WebDriverWait(cd, Duration.ofSeconds(20));
		waitforPass.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		cd.findElement(By.id("password")).sendKeys("qwerty@123");

//		WebElement next = cd.findElement(By.xpath("//button[@id='nextbtn']"));
//		next.click();
		
//		WebElement change = waitforPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='password_container']//span[@class='Notyou bluetext'][normalize-space()='Change']")));
//		change.click();
//		WebElement usingEmailOTP = waitforPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='enablemore']//span[@class='bluetext_action showmoresigininoption'][normalize-space()='Sign in using email OTP']")));
//		usingEmailOTP.click();
//		WebElement forgotpassword = waitforPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='login']//div[@id='enablemore']//span[@id='blueforgotpassword']")));
//		forgotpassword.click();
	}
	
	
	
	public static void SingUpErrorMessage() {
		cd = new ChromeDriver();
		cd.get("https://www.zoho.com/");
		WebElement clickcheckbox = cd.findElement(By.xpath("//a[normalize-space()='Sign Up']"));
		clickcheckbox.click();
		
		// Implicit wait
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Send key data
		cd.findElement(By.id("email")).sendKeys("aguleria7@");
		cd.findElement(By.id("password")).sendKeys("Aguler");
		cd.findElement(By.id("rmobile")).sendKeys("9876540");
		cd.findElement(By.xpath("//*[@id=\"signupform\"]/div/div[2]/div/button")).click();
		
		//Getting send key data
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String email = cd.findElement(By.id("email")).getAttribute("value");
		String password = cd.findElement(By.id("password")).getAttribute("value");
		WebElement countrycode = cd.findElement(By.xpath("//*[@id=\"signupform\"]/div/div[3]/div/div/input[1]"));
		String code = countrycode.getAttribute("value");
		String mobile = cd.findElement(By.id("rmobile")).getAttribute("value");
		
		
		// Print getting data
		System.out.println("--------- Send keys  ---------");
		System.out.println("Email:- " + email);
		System.out.println("Password:- " + password);
		System.out.println("Mobile:- " + code + " " + mobile );
		
		// Click on button
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		cd.findElement(By.id("signupbtn")).click();
		
		//getting error message
		String emailerror = cd.findElement(By.id("email-error")).getText();
		String passerror = cd.findElement(By.id("password-error")).getText();
		String phnerror = cd.findElement(By.id("rmobile-error")).getText();
		String policyerror = cd.findElement(By.id("tos-error")).getText();

		// Print error message
		System.out.println(" ");
		System.out.println("--------- Error's ---------");
		System.out.println("Email error:- " + emailerror);
		System.out.println("Password error:- " + passerror);
		System.out.println("Phone error:- " + phnerror);
		System.out.println("Policy error:- " + policyerror);
		
		
	}
	

}
