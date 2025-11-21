package TestCases.suiteA;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertStudy {
	
	@Test
	public void validates() {
		
		String ExpectedResult = "Two";
		String ActualResult = "Two";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualResult, ExpectedResult);
		softAssert.assertEquals("One", "Two");
		softAssert.assertTrue(5>11, "Error:- not greater");
		softAssert.fail("Error message 1");
		System.out.println("A ------------");
		softAssert.assertAll();
		
	}

}
