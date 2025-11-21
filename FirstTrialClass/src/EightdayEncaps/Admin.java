package EightdayEncaps;

public class Admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int age;
	private String name;
	
	
	public String getName() 
	{
		return name;
		
	}
	
	public void setName(String names) 
	{
		this.name = names;
	}
	
	
	public int getAge() 
	{
		return age;
		
	} 
	
	public void setAge(int ages) 
	{
		if(ages >= 18) {
		
			this.age = ages;
			
		} else {
			
			System.out.println("You are not eligible for voting");
		}
		
	}
	
}
