package FifthDay;

public class yamahabike extends herobike{

	@Override
	public void bikerefuel()
	{
		
		System.out.println("Yamaha Bike is refueling with name: " + name);
		fuelcapcity = fuelcapcity + 50;
	}
	
	public void testyamahabike()
	{
		System.out.println("Yamaha bike testing is start");
	}
	
}
