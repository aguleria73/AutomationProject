package FourthDay;

public class FunctionOverloading {
	
	public static void main(String[] args) {
		
		int result1 = sumAll(50, 4);
		System.out.println("Function overloading with 2 parameters(Datatype INT)");
		System.out.println(result1);
		System.out.println(" ");
		
		int result2 = sumAll(10, 25, 30);
		System.out.println("Function overloading with 3 parameters (Datatype INT)");
		System.out.println(result2);
		System.out.println(" ");
		
		String result3 = colorsName("Red ", "Green");
		System.out.println("Function overloading (Datatype String) ");
		System.out.println(result3);
		System.out.println(" ");
		
		
		System.out.println("Function overloading (Datatype boolean) ");
		boolean yess = trueFalse(true);
		System.out.println("  ");
		
	
		
		FunctionOverloading fo1 = new FunctionOverloading();
		fo1.add(10.6, 10.5);
		fo1.add(11, 12);
		fo1.add(2, 3, 5);
		fo1.add("Ashish ", "Guleria");
		fo1.add(true, false);
		
		ifelse();
		

	}
	
public static void ifelse() {
		
		int a = 13, b = 12;
		if (a > b)
		{
			System.out.println("A is greater");
			
		} else {
			
			System.out.println("B is greater");
		}
	}
	
	
	
	
	
	public static int sumAll(int a, int b)
	{
		int sum1 = a + b;
		return sum1;
	}
	
	public static int sumAll(int a, int b, int c) 
	{
		int sum2 = a + b + c;
		return sum2;
	}
	
	public static String colorsName(String color1, String color2)
	{
		String colors_1 = color1 + color2;
		return colors_1;
	}
	
	public static boolean trueFalse(boolean yes)
	{
		if(yes) 
		{
			System.out.println("you are elder");
		} else {
			System.out.println("You are younger");
		}
		return yes;
		
	}
	
	public void add(double a, double b)
	{
		double add = a+b;
		System.out.println("Function overloading -- Add logic: " + add);
		
	}
	
	public void add(int a, int b)
	{
//		int multiply = a*b;
//		System.out.println("Function overloading -- multiply logic: " + multiply);
		
		if (a > b)
		{
			System.out.println("A is greater");
			
		} else {
			
			System.out.println("B is Samller");
		}
		
		if (a < b)
		{
			System.out.println("B is greater");
			
		} else {
			
			System.out.println("A is Samller");
		}
		
	}
	
	public void add(int d, int e, int f )
	{
		int add = d + e + f;
		System.out.println("Function overloading -- add logic: " + add);
		
	}
	
	public void add(String d, String e)
	{
		String name = d+e;
		System.out.println("Function overloading -- String Concatlogic: " + name);
		
	}
	
	public void add(boolean d, boolean e)
	{
		boolean name1 = d;
		boolean name2 = e;
		System.out.println("Function overloading -- boolean Concatlogic: " + name1);
		System.out.println("Function overloading -- boolean Concatlogic: " + name2);
		
	}
	
	
	
	
	

}
