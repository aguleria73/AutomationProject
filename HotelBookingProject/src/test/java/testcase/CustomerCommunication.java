package testcase;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunication {
	
	@Test
	public void checkingEmail(ITestContext context) {
		
		String bookingID = (String) context.getAttribute("Booking ID is:- ");
		System.out.println("Checking email for conformation, Booking ID:- " + bookingID);
		System.out.println(" ");
	}

}
