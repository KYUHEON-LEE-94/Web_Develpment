package collectionFramework;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LinkedHashSetExample {

	public static void main(String[] args) {

		
		Set<String> set = new LinkedHashSet<>();
		

		set.add("java");
		set.add("java script");
		set.add("HTML");
		set.add("java");
		set.add("C");
		
		System.out.println(set.size());
		
		
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String text = it.next();
			System.out.println(text);
			}
			
		
		
		System.out.println(set.contains("java"));
		System.out.println(set.remove("java")); //boolean값으로
		System.out.println(set.size());
//		set.clear();

		
		

		

	}

}

