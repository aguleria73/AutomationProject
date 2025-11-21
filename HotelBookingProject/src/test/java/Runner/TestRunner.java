package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {
		TestNGRunner runner = new TestNGRunner(1);
		runner.createSuite("Booking Suite", false);
		runner.addTest("Creating booking -- default Discount");
		runner.addTestParameter("action", "deafultdiscount");
		List<String> includedMethodNames = new ArrayList<String>();
		includedMethodNames.add("searchHotel");
		includedMethodNames.add("selectingHotel");
		includedMethodNames.add("enterGustInfo");
		runner.addTestClass("testcase.bookingSearch", includedMethodNames);
		
		includedMethodNames = new ArrayList<String>();
		includedMethodNames.add("applyDiscount");
		includedMethodNames.add("makePayment");
		runner.addTestClass("testcase.PaymentManager", includedMethodNames);
		
		includedMethodNames = new ArrayList<String>();
		includedMethodNames.add("checkingEmail");
		runner.addTestClass("testcase.CustomerCommunication", includedMethodNames);
		
		runner.run();
		

	}

}
