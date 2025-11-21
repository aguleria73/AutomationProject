package SixDayAbstract;

public abstract class VillageHospital implements Hospital{

	@Override
	public void diagnosticservices() {
		System.out.println("Village Hospital diagnostic services");
		
	}

	@Override
	public void emergencycare() {
		System.out.println("Village Hospital emergency care");
		
	}

}
