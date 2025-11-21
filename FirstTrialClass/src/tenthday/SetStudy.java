package tenthday;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class SetStudy {

	public static void main(String[] args) {
		
		Set<String> s = new HashSet<String>();
		
		System.out.println(s.size());
		
		s.add("One");
		s.add("Two");
		s.add("Three");
		s.add("Four");
		
		Iterator<String> i = s.iterator();
		
		while(i.hasNext())
		{
			String count = i.next();
			System.out.println(count);
			
			if(count.equals("three"))
			{
				i.remove();
				System.out.println(i);
			}
			
		}
		System.out.println(i.hasNext());
		System.out.println(s);

	}

}
