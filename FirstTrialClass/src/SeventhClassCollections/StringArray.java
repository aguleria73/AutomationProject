package SeventhClassCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StringArray {
	public static void main(String[] args) {
	
//		arraylist();
//		MapHashTable();
//		SetHashSet();
//		SetTreeSet();
//		MapTreeMap();
		Maphashtable1();
//		SortReverseShufflecheck();
		
	
	}
	
	public static void arraylist() {
	
		List<String> l1 = new ArrayList<String>();
		
//		ArrayList<String> al1 = new ArrayList<String>();
	
		//Find of Size
		System.out.println(l1.size());
		System.out.println("   ");
		l1.add("Apple");
		l1.add("Mango");
		l1.add("Kiwi");
		l1.add("Mango");
		l1.add("Orange");
		l1.add("Mango");
		
		//Print all the list
		System.out.println("asd"+l1);
		
		Collections.shuffle(l1);
		
		System.out.println("------------------");
		
		// Total size
		System.out.println(l1.size());
		
		// Access elements by index
		System.out.println(l1.get(2));
		System.out.println(" ");
		
		// Remove element
		System.out.println(l1.remove(1)); 
		System.out.println(l1.remove("Mango"));
		System.out.println("After remove" + l1);
		System.out.println(" ");
		
		// Add element according to the index
		l1.add(1,"Dragon");
		System.out.println("Adding element in index" + l1);
		System.out.println(" ----");
				
		// Print all the element using for loop
		System.out.println("Print all the element using For Loop");
		for(int i=0; i<l1.size(); i++) {

			System.out.println(l1.get(i));
		}
		
	
		
//		l1.clear();
//		System.out.println(l1);
		
		
		System.out.println("    ");
		System.out.println("------Hash MAP------");
	
	}
	
	public static void MapHashTable() {
	
		//Map -- Hashtable
		
		Hashtable< Integer, String> ht = new Hashtable< Integer, String>();
		ht.put(1, "Ashish");
		ht.put(2, "Deepak");
		ht.put(3, "Rahul");
		ht.put(4, "Inderjeet");
		ht.put(4, "Sachin");
		ht.put(5, "Deepak");
		ht.put(6, "");
		
		// Accessing element
		System.out.println(ht.get(2));
		
		// Removing Element
		ht.remove(3);
		System.out.println(ht);
		
		// Size
		System.out.println(ht.size());
		
		// Checking if key or value exists
		System.out.println(ht.containsKey(4));
		System.out.println(ht.containsValue("Salman"));
		
		
		// clear the hashmap
		System.out.println("Checking empty or not:- " + ht.isEmpty());
		ht.clear();
		System.out.println(ht);
		System.out.println("Checking empty or not:- " + ht.isEmpty());
		
	}
	
	public static void SetHashSet() {
		
		Set<String> hs = new HashSet<>();
		//Set<String> hs = new HashSet<>(Arrays.asList("a", "b","a","c"));
		
		hs.add("Apple");
		hs.add("Banana");
		hs.add("Apple");
		hs.add("Mango");
	
		
		//Print all the element
		System.out.println(hs);
		
		//Total size
		System.out.println(hs.size());

		//Remove particular element
		hs.remove("Apple");
		System.out.println(hs);
		
		//Check if exist
		System.out.println(hs.contains("Apple"));
		
		
		
	}
	
	public static void SetTreeSet() {
		
		Set<String> ts = new HashSet<String>();
		
//		ts.add(10);
//		ts.add(5);
//		ts.add(4);
//		ts.add(3);
//		ts.add(2);
		
		
		ts.add("B");
		ts.add("c");
		ts.add("A");
		ts.add("E");
		ts.add("E");
		ts.add("D");
		System.out.println(ts);
	}
	
	public static void MapTreeMap() {
		Map<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(1, "A");
		tm.put(3, "C");
		tm.put(2, "B");
		//tm.put(null, "B");
		tm.put(4, null);
		
		System.out.println(tm);
				
	}
	
	public static void Maphashtable1() {
		Map<Integer, String> ht1 = new Hashtable<Integer, String>();
		
		ht1.put(1, "A");
		ht1.put(3, "C");
		ht1.put(2, "B");
		ht1.put(3, "D");
		ht1.put(4, "B");
		
		
		System.out.println(ht1);
				
	}
	
	
	public static void SortReverseShufflecheck() {
		
		List<String> l1 = new ArrayList<String>();
		
		//Find of Size
		System.out.println(l1.size());
		System.out.println("   ");
		l1.add("Apple");
		l1.add("Mango");
		l1.add("Kiwi");
		l1.add("Mango");
		l1.add("Orange");
		l1.add("Mango");
		l1.add("Banana");
		
		
		
		Collections.shuffle(l1);
		
		System.out.println("After Shuffle:- "+l1);
		
		Collections.reverse(l1);
		System.out.println("After Reverse:- "+l1);
		
		Collections.sort(l1);
		System.out.println("After Sort:- "+l1);
	}
	
	
}
