package ThirteenDay;


public class TempBroswer {

	public static void main(String[] args) {
//		WebDriver wd = null;
//		wd = new ChromeDriver();
//		wd.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AdBytiMgXiyVKqqZ1jKffBIB0VGl6InVQzXyD4_zrrohnjTMrFzHY_7z4FdWv4eqWnOr0dOQUsnkUA&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S605263579%3A1757948163965748");
//		System.out.println(wd.getTitle());
//		wd = new FirefoxDriver();
//		wd.get("https://www.croma.com/raiseArequest");
//		System.out.println(wd.getTitle());
		
//		WebDriver wd;
		Base b1 = new Base();
		b1.launchbroser("Chrome");
//		wd.get("https://www.croma.com/raiseArequest");
		b1.openURL("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AdBytiMgXiyVKqqZ1jKffBIB0VGl6InVQzXyD4_zrrohnjTMrFzHY_7z4FdWv4eqWnOr0dOQUsnkUA&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S605263579%3A1757948163965748");
		
		
		

	}

}
