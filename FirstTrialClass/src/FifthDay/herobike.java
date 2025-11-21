package FifthDay;

public class herobike extends Bike{
	
	
	public void seatingcapcity()
	{
		System.out.println("  ");
		System.out.println("Seating Capcity of saplander ");
	}
	
	@Override
	public void bikerefuel()
	{
		System.out.println("Saplander Bike is refueling with name: " + name);
		fuelcapcity = fuelcapcity + 40;
	}
	
	public void bikerefuel(int fuelquantity, String seatingcount)
	{
		System.out.println("Saplander bike seating count: " + seatingcount);
		fuelcapcity = fuelcapcity + fuelquantity;
	}
	

}
