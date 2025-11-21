package SixDayAbstract;

public class TestHospital {

	public static void main(String[] args) {
//		VillageHospital vh = new VillageHospital();
		
		CityHospital ch = new CityHospital();
		ch.diagnosticservices();
		ch.emergencycare();
		ch.MRI();
		ch.ICU();
		
		
		

	}

}
