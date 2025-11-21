package FifthDay;

public class biketesting {

	public static void main(String[] args) {
		
		
//		Bike b = new Bike();
//		b.name = "Bajaj";
//		b.fuelcapcity = 100;
//		System.out.println(b.name);
//		System.out.println(b.fuelcapcity);
//		
//		
//		
//		Bike b1 = new Bike("Bajaj", 200);
//		System.out.println(b1.name);
//		System.out.println(b1.fuelcapcity);
//		b1.start();
//		b1.bikerefuel();
//		System.out.println(b1.fuelcapcity);
//		
//		b1.bikerefuel(20);
//		System.out.println(b1.name);
//		System.out.println(b1.fuelcapcity);
		
		herobike h = new herobike();
		h.name ="Saplander";
		h.fuelcapcity = 200;
		System.out.println(h.name);
		System.out.println(h.fuelcapcity);
		System.out.println("  ");
		h.start();
		h.bikerefuel(); 
		h.bikerefuel(30); 
		h.seatingcapcity();
		h.bikerefuel(10, "2");
		System.out.println(h.name);
		System.out.println(h.fuelcapcity);
		
		
//		Bike b2 = new herobike();
//		b2.start();
//		b2.bikerefuel();
//		b2.bikerefuel(20);
//		System.out.println(b2.fuelcapcity);
		
		
		
		
		
		
		

	}

}
