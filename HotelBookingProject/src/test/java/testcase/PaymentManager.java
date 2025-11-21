package testcase;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager {

	@Test
	public void applyDiscount() {
		
		System.out.println("Appling discount");
	}
	
	@Parameters({"action"})
	@Test
	public void makePayment(String paymentType, ITestContext context) {
		
		if(paymentType.equals("deafultdiscount"))
		{
			System.out.println("Discount 10%");
			System.out.println("Making Payment");
		}
		else if(paymentType.equals("nodiscount"))
		{
			System.out.println("No discount");
			System.out.println("Making Payment");
		}
		else if(paymentType.equals("payathotel"))
		{
			System.out.println("Discount 20%");
			System.out.println("Making Payment");
		}
		
		String bookingID = "B-ID123";
		context.setAttribute("Booking ID is:- ", bookingID);
	}
}
