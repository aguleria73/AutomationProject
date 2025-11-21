package SeventeenDay;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GettingDateYatra {
static FirefoxDriver driver;
	
	
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement LoginModal = driver.findElement(By.xpath("//span[@class='style_cross__q1ZoV']//img[@alt='cross']"));
		LoginModal.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait WaitforClickOnDepartureDate = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement DepartureDate = WaitforClickOnDepartureDate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div[2]")));
		DepartureDate.click();

		selectDate("25-10-2025");
		driver.quit();
	}
	
	public static void selectDate(String date) {
		
		DateTimeFormatter dateFormate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(date, dateFormate);
		System.out.println("Date converted into locale date:- "+localDate);
		int dayOfMonth = localDate.getDayOfMonth();
		System.out.println("Day of month:- " + dayOfMonth);

		// Month as number:- date is (25-Dec-2025)
//		int Month = localDate.getMonthValue();
//		System.out.println("Month2:- "+ Month);
		
		// Month as TEXT :-  Date is (25-12-2025)
		Month month = localDate.getMonth();
		System.out.println("Month:- "+ month);
		
		// Month in lower Case
		String MonthInLower = localDate.format(DateTimeFormatter.ofPattern("MMMM"));
		System.out.println("Month in Lower case:- "+ MonthInLower);
		
		// Week as text
		DayOfWeek weekName= localDate.getDayOfWeek();
		System.out.println("Week Name:- "+weekName);
		
		// Week in Lower case
		String WeekNameInLower = localDate.format(DateTimeFormatter.ofPattern("EEEE"));
		System.out.println("Week Name in Lower case:- "+ WeekNameInLower);
		
		//Year
		int year = localDate.getYear();
		System.out.println("Year:- "+ year);
		
		String FinalMonthYearForSelection = MonthInLower +" "+ year;
		System.out.println("Final Month Year For Selection:- " + FinalMonthYearForSelection);
		
		WebElement DepatureCalenderMonthYear = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[4]/div/div/div/div/div/div/div[2]/div[1]/div[1]/div/span"));
		System.out.println(DepatureCalenderMonthYear.getText());
		
		while(true) 
		{
			if(FinalMonthYearForSelection.equals(DepatureCalenderMonthYear.getText()))
			{
				System.out.println("Found & Display");
				driver.findElement(By.xpath("//div[@aria-label='Choose "+WeekNameInLower+", "+MonthInLower+" "+dayOfMonth+"th, "+year+"']")).click();
				break;
			} 
			else 
			{
				DateTimeFormatter viewformatter = DateTimeFormatter.ofPattern("MMMM yyyy");
				YearMonth MonthYearToBeSelected = YearMonth.parse(FinalMonthYearForSelection, viewformatter);
				YearMonth MonthYearIsDisplay = YearMonth.parse(DepatureCalenderMonthYear.getText(), viewformatter);
				System.out.println("First else");
				System.out.println(" ");
				if(MonthYearToBeSelected.isAfter(MonthYearIsDisplay)) 
				{
					WebElement forwardArrow = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[4]/div/div/div/div/div/div/div[3]/div[1]/div[1]/div/button[2]"));
					forwardArrow.click();
					System.out.println("Second IF");
				}
				else 
				{
					System.out.println("Second else");
					System.out.println(" ");
				}

			}
		}

	}

}