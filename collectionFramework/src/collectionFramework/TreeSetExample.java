package collectionFramework;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {

		
		Set<String> set = new TreeSet<>();
		

		set.add("java");
		set.add("java script");
		set.add("HTML");
		set.add("java");
		
		System.out.println(set.size());
		//set은 무작위로 정렬되기 떄문에 저장된 값을 불러올 메소드가 없음
		
		
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

