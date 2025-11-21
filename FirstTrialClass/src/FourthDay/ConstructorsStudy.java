package FourthDay;

public class ConstructorsStudy {

	String bikename;
	String bikemodel;
	String bikecolor;
	int bikeprice;
	boolean discount ;
	double interset;
	
	
	// Default constructor
	public ConstructorsStudy() 
	{
		System.out.println("Constructor Calling");
		
	} 
	
	// Parameterize constructor	
	public ConstructorsStudy(String bikenames, String bikemodels, 
			String bikecolors, int bikeprices, boolean discounts, double intersets)
	{
		System.out.println("---Parameterize constructor---");
		this.bikename = bikenames;
		this.bikemodel = bikemodels;
		this.bikecolor = bikecolors;
		this.bikeprice = bikeprices;
		this.discount = discounts;
		this.interset = intersets;
	}
	
	
	public static void main(String[] args) {
		//new ConstructorsStudy();
		
//		ConstructorsStudy cs3 = new ConstructorsStudy("Heros", "2021", "Blacks", 30000, true, 12.5);
//		System.out.println(cs3.bikename + " " + cs3.bikemodel + " " + 
//		cs3.bikecolor + " " + cs3.bikeprice + " " + cs3.discount + " " + cs3.interset);
//		
//		
//		ConstructorsStudy cs4 = new ConstructorsStudy("Bajajs", "2023", "Whites", 60000, false, 10.5);
//		System.out.println(cs4.bikename + " " + cs4.bikemodel + " " + 
//		cs4.bikecolor + " " + cs4.bikeprice + " "  + cs4.discount + " " + cs4.interset);

	}

}
