package SecondDay;

public class SecondDay {

	public static void main(String[] args) 
	{
	
		//SecondDay SD = new SecondDay();
		
//	leftTriangle();
//	rightReverseTriangle();
	PyramidStar();
	PyramidReverseStar();
//	evenNumber();
//	whileloop();
//	forloop();
//	stringlogic();
//	Increment();
//	Array();
	}
	
	
	public static void leftTriangle()
	{
		System.out.println("Left Triangle Start");
		System.out.println(" ");
		int a, b;
		for(a=1; a<=5; a++)
		{
			for(b=1; b<=a; b++)
			{
				System.out.print("* ");
			}
			System.out.println();
			
		}
		System.out.println("  ");
		System.out.println("Left Triangle End.");
		System.out.println(" ");
	}
	
	public static void rightReverseTriangle()
	{
		System.out.println("Right reverse triangle Start");
		System.out.println("  ");
		int c, d;
		
		for(c=1; c<=5; c++)
		{
			for(d=5; d>=c; d--)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println(" ");
		System.out.println("Right reverse triangle End.");
		System.out.println(" ");
	}
	
	
	public static void PyramidStar ()
	{
		System.out.println("Pyramid Star start.");
		System.out.println(" ");
		int e, f, g;
		for(e=1; e<=5; e++)
		{
			for(f=5-e; f>=1; f--)
			{
				System.out.print(" ");
			}
				for(g=1; g<=e; g++)
				{
					System.out.print("* ");
				}
		
			System.out.println();
		}
		System.out.println("  ");
		System.out.println("Pyramid Star Triangle End");
		System.out.println("  ");
	}
	
	public static void PyramidReverseStar()
	{
		System.out.println("Pyramid reverse star start.");
		System.out.println("  ");
		int h, i, j;
		for(h=1; h<=5; h++)
		{
			for(i=1; i<=h; i++)
			{
				System.out.print(" ");
			}
			for(j=6-h; j>=1; j--)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("Pyramid reverse star End.");
		System.out.println("  ");
	}
	

	
	// Even function
	public static void evenNumber() 
	{
		System.out.println("Even function Start");
	int even;
	
	for(even=1; even <= 10; even++)
	{
		if(even %2 ==0) 
		{
		System.out.println(even);
		}
	}
	System.out.println("  ");
	System.out.println("Even function end");
	System.out.println("  ");
	
	}
	
	
	// While loop function
	public static void whileloop()
	{
		System.out.println("WhileLoop function Start");
		int i = 1;
		while(i <= 10)
		{
			System.out.println(i);
			i++;
		}
			
		System.out.println("  ");
		System.out.println("WhileLoop function end");
		System.out.println("  ");
	}
	
	
	// For loop function
	public static void forloop()
	{
		System.out.println("ForLoop function Start");
		
		int w;
		for(w=1; w<=10; w++)
		{
			if(w==5) 
			{
				break;
			}
			System.out.println(w);
			
			
		}
		System.out.println("  ");
		System.out.println("ForLoop function end");
		System.out.println("  ");
	}
	
	
	public static void stringlogic()
	{
		System.out.println("String Logic Start");
		System.out.println("  ");
		
		String s = "My name is Ashish Guleria. I'm from Himachal Pradesh.";
		String sresult[] = s.split("Ashish");
		
		System.out.println(sresult.length);
		
		for(int a=0; a<sresult.length; a++)
		{
			System.out.println(sresult[a]);
		}
		
		
		System.out.println("How many character in string");
		System.out.println(s.length());
		
		System.out.println(" ");
		System.out.println("Character position");
		System.out.println(s.charAt(9));
		
		System.out.println(" ");
		System.out.println("Read all the Character");
		for(int h=0; h<s.length(); h++)
		{
			System.out.print(s.charAt(h));
			
		}
		System.out.println();
		System.out.println(" ");
		System.out.println("Read Character according to the letter");
		for(int h=0; h<s.length(); h++)
		{
			System.out.print(s.charAt(h));
			char var1 = '.';
			char var2 = s.charAt(h);
			if(var1 == var2)
			{
				break;
			}
		}
		System.out.println();
		System.out.println("  ");
		System.out.println("Replace Character 1");
		System.out.println(s.replace(" ", "_"));
		
		System.out.println("Replace Character 2");
		String s2 = s.replace(" ", "_");
		System.out.println(s2);
		
		System.out.println("Replace Character 3");
		s = s.replace(" ", "_");
		System.out.println(s);
		
		
		
		System.out.println("  ");
		System.out.println("String Logic End");
	}
	
	public static void Increment()
	{
		System.out.println("------------");
		System.out.println("Increment Start");
		System.out.println("  ");
		
		int i = 100;
		System.out.println("Post increment");
		System.out.println(i);
		System.out.println(i++);
		
		
		int b =100;
		System.out.println("Pre increment");
		System.out.println(b);
		System.out.println(++b);
		
		
		System.out.println("  ");
		System.out.println("Increment End");
	}
	
	
	public static void Array()
	{
		System.out.println("------------");
		System.out.println("Array Function Start");
		System.out.println("  ");
		
		String arr[] = new String[5];
		arr[1] = "Ashish";
		arr[3] = "Deepak";
		arr[4] = "Naushad";
		
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
		int arr1[] = new int[5];
		arr1[0] = 10;
		arr1[2] = 20;
		
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr1[i]);
		}
		
		
		int a = 10; 
		int b = 20;
		int c = 30;
		
		a=c;
		b=a;
		c=b;
		System.out.println("a:" + a + " b:" + b+ " c:" + c);
		
		Object[] obj = new Object[6];
		obj[0] = "Ashish";
		obj[1] = 10;
		obj[2] = false;
		obj[3] = 3.66;
		obj[5] = true;
		
		for(int h=0; h<obj.length; h++)
		{
		System.out.println(obj[h]);
		}
		
			
		System.out.println("  ");
		System.out.println("Array Function End");
	}
	
	
}



