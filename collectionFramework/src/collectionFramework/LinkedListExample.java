package collectionFramework;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class LinkedListExample {

	public static void main(String[] args) {

		
		List<String> list = new LinkedList<String>();
		
		
		list.add("java");
		list.add("java script");
		list.add("HTML");
		list.add("java");
		
		//insert 기능
		list.add(0, "CSS");
		//update 기능
		list.set(0, "C");
		//delete 기능
		list.remove(0); //index값으로 할수도있고, boolean값을 리턴하는 것도있고
		
//		System.out.println(list.subList(0,2)); //끝번호 -1;
		
		//---list의 객체를 나눠서 담아서 이터레이터로 출력해보자
		List<String> sublist = list.subList(0,2);
		Iterator<String> iter = sublist.iterator();
		while(iter.hasNext()) {
			String text = iter.next();
			System.out.println(text);
			}
		
		System.out.println(list.get(1));
		System.out.println(list.size());
	
		//===기본
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			String text = it.next();
			System.out.println(text);
			}
			
		ListIterator<String> it2 = list.listIterator();
			System.out.println(it2.next());
			System.out.println(it2.previous());
		
		


		
		
		

	}

}

