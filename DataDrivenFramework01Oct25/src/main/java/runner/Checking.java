package runner;

import java.util.HashMap;

public class Checking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testing();
		maping();
		int[] arr = new int[5];
		System.out.println(arr[0]);
		System.out.println("Java" + 10+ 20);
		
		
		String s1 = "Java";
		String s2 = s1;
		s1 = s1 + " Quiz";
		System.out.println(s2);
		System.out.println(s1);
		
		
		
		
		
		try 
		{
			int x=10/0;
		} 
		catch (Exception e) 
		{
			System.out.println("Exception:- " + e);
		}
		finally 
		{
			System.out.println("Finally");
		}
		System.out.println("After");
		
	}
	
	public static void testing() 
	{
		System.out.println("----- testing function-----");
		System.out.println(" ");
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = s3.intern();
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println("----- testing function-----");
	}
	
	
	public static void maping() 
	{
		maths();
		System.out.println("----- MAP function-----");
		System.out.println(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		System.out.println(map.size());
		System.out.println("----- MAP function-----");
	} 
	
	public static void maths() 
	{
		System.out.println("----- maths function-----");
		int a = 5;
		System.out.println("1:- "+ a);
		a= a++;
		System.out.println("2:- "+ a);
		int result = a + ++a;
		System.out.println(result);
		System.out.println(17%5);
		System.out.println("   ");
		
		final int x=10;
//		x=20;
		System.out.println("X:-  "+ x);
		
		System.out.println("----- maths function-----");
	}

}
