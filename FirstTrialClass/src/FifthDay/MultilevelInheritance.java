package FifthDay;

public class MultilevelInheritance {

	public static void main(String[] args) {
		yamahabike yb = new yamahabike();
		yb.name = "KTM";
		yb.fuelcapcity = 100;
		yb.start();
		
		yb.bikerefuel(); //150
		System.out.println(yb.fuelcapcity);
		
		yb.bikerefuel(30); //180
		System.out.println(yb.fuelcapcity);
		
		yb.bikerefuel(60, "KTM Bike"); //240
		System.out.println(yb.name);
		System.out.println(yb.fuelcapcity);
		yb.testyamahabike();

	}

}
