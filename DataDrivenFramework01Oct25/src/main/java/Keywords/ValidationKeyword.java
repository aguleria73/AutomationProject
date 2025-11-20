package Keywords;

import com.aventstack.extentreports.Status;

public class ValidationKeyword extends GenericKeywords {

	
	public void ValidateTitle() {
		
		
	}
	
	public boolean validateText(String actualTextLocatorKey, String locatorKey) {
		test.log(Status.INFO, "Validate Text :- "+ actualTextLocatorKey + " " + "Getting data " + locatorKey);
		String actualText = getText(locatorKey);
		String expectedText = envProp.getProperty(actualTextLocatorKey);
		if(expectedText.equals(actualText)) 
		{
			return true;
		}
		return false;
	}
	
	public boolean ValidateElementPresent(String locator) {
		boolean result = false;
		result = isElementPresent(locator);
		return result;
		
	}
}
