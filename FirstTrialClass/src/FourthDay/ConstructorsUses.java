package FourthDay;

public class ConstructorsUses {
	
	public static void main(String[] args) {
		new ConstructorsStudy();
		new ConstructorsStudy();
		
		ConstructorsStudy cs3 = new ConstructorsStudy("Hero", "2021", "Black", 30000, true, 12.5);
		System.out.println(cs3.bikename + " " + cs3.bikemodel + " " + 
		cs3.bikecolor + " " + cs3.bikeprice + " " + cs3.discount + " " + cs3.interset);
		
		
		ConstructorsStudy cs4 = new ConstructorsStudy("Bajaj", "2023", "White", 60000, false, 10.5);
		System.out.println(cs4.bikename + " " + cs4.bikemodel + " " + 
		cs4.bikecolor + " " + cs4.bikeprice + " "  + cs4.discount + " " + cs4.interset);
	}

}
