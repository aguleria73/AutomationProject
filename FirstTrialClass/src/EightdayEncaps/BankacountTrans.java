package EightdayEncaps;

public class BankacountTrans {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		
		ba.depositAmount(1000);
		ba.withdrawAmount(500);
		
		System.out.println("   ");
		System.out.println("Final balance:- "+ ba.getBalance());

	}

}
