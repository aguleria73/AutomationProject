package SixDay;

public class TestBajajMotercycle {

	public static void main(String[] args) {
		
		Motercycle mc = null;
		
		Bajajmotercycle bm = new Bajajmotercycle();
//		bm.companyname();
//		bm.fuelefficiency();
//		bm.typeofmotercycle();
//		bm.motercycleweight();

		
		mc = new Bajajmotercycle();
		mc.companyname();
		mc.fuelefficiency();
		mc.typeofmotercycle();
		mc.motercycleweight();
		bm.comfort();
		
		Heromotercycle hm = new Heromotercycle();
		
		mc = new Heromotercycle();
		mc.companyname();
		mc.fuelefficiency();
		mc.typeofmotercycle();
		mc.motercycleweight();
		hm.average();
		
		
		
	}
}
