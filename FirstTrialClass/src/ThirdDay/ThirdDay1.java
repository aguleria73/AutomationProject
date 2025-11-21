package ThirdDay;

public class ThirdDay1 {

	public static void main(String[] args) {
		
		ThirdDay2 td2 = new ThirdDay2();
		td2.URL = "www.google.com";
		td2.pagenumber = 200;
		
		
		ThirdDay2 td3 = new ThirdDay2();
		td3.URL = "www.youtube.com";
		td3.pagenumber = 400;
		
		System.out.println(td2.URL);
		System.out.println(td2.pagenumber);
		
		System.out.println(td3.URL);
		System.out.println(td3.pagenumber);

	}

}
