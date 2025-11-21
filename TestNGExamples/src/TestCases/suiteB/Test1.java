package TestCases.suiteB;

import org.testng.annotations.Test;

public class Test1 {
	//Twenty-one Day

	@Test(priority = 1)
	public void search() {
		
		System.out.println("Selecting Function one @Search");
	}
	
	@Test (priority = 3)
	public void select() {

		System.out.println("Selecting Function two @Select");
	}
	
	@Test(priority = 2)
	public void Payment() {

		System.out.println("Selecting Function Three @Payment");
	}
}
