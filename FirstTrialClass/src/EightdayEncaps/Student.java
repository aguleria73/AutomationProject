package EightdayEncaps;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s = new Student();
		s.sumall(20, 30);
		
	}

	
	public void sumall(int q, int w)
	{
		Office o = new Office();
		int sum = o.getSum(q, w);
		System.out.println("Result:- " + sum);
	}
}
