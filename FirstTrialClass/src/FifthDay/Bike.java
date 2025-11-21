package FifthDay;

public class Bike {
	
	String name;
	int fuelcapcity;
	
	public Bike()
	{
		System.out.println("In bike constructor");
		
	}
	
	
	public Bike(String names, int fuelcapcities)
	{
		System.out.println("  ");
		System.out.println("In bike paramertized constructor");
		
		this.name = names;
		this.fuelcapcity = fuelcapcities;
		
		
	}
	
	public void start()
	{
		System.out.println("Bike start with name of bike: " + name);
	}
	
	
	public void bikerefuel()
	{
		System.out.println("Bike is refueling with name: " + name);
		fuelcapcity = fuelcapcity + 20;
	}
	
	
	public void bikerefuel(int fuelquantity)
	{
		System.out.println("Bike is refueling quantity with name: " + name);
		fuelcapcity = fuelcapcity + fuelquantity;
	}
	
	

}
