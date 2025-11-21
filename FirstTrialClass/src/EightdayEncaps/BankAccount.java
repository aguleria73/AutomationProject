package EightdayEncaps;

public class BankAccount {
	
	private double balance;
	
	public void depositAmount(double depositamount)
	{
		
		if(depositamount > 0) 
		{
			balance += depositamount;
			
			showtransaction("Desposit", depositamount );
			
		} else {
			
			System.out.println("Amount should be greater to the 0");
		}
	}
	
	public void withdrawAmount(double withdrawamount) {
		
		if(withdrawamount <= balance && withdrawamount > 0) 
		{
			balance -= withdrawamount;
			
			showtransaction("Withdraw", withdrawamount);
			
		} else {
			System.out.println("Withdraw amount should not be less to the account balance");
		}
		
	}
	
	public double getBalance() 
	{
		return balance;
		
	}
	
	private void showtransaction(String type, double amount) 
	{
		
		System.out.println(type + ":- " + amount + " | Current balance:- " + balance);
		
	}

}
