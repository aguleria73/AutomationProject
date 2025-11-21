package ThirdDay;

public class StaticStudy {

	public static void main(String[] args) {
		sum();
		
		//StaticStudy ss= new StaticStudy();
		//ss.minus();

	}
	
	public static void sum(){
		System.out.println("Sum function start");
		int a= 10;
		int b= 20;
		int c= a+b;
		
		System.out.println(c);
		System.out.println("Sum function end");
	}
	
	public static void multiply(){
		System.out.println("  ");
		System.out.println("Multiply function start");
		int a= 10;
		int b= 20;
		int c= a*b;
		
		System.out.println(c);
		System.out.println("Multiply function end");
	}
	
	
	public void minus() {
		multiply();
		System.out.println("  ");
		System.out.println("Minus function start");
		int a= 10;
		int b= 20;
		int c= a-b;
		
		System.out.println(c);
		System.out.println("Minus function end");
		
	}

}
