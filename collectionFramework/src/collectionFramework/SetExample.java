package collectionFramework;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Calendar some = Calendar.getInstance();
		some.get(Calendar.APRIL);
		
		Set set = new HashSet();
		
		set.add(10);
		set.add(35.6);
		set.add("java");
		set.add("java script");
		set.add("HTML");
		set.add(some.get(Calendar.DATE));
		set.add("java");
		
		System.out.println(set.size());
		//set은 무작위로 정렬되기 떄문에 저장된 값을 불러올 메소드가 없음
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
//			System.out.println(it.next());
			Object obj = it.next();
			if(obj.equals("java")) {
				it.remove();
			}
			
		}
		
		System.out.println(set.contains("java"));
		System.out.println(set.remove("java"));
		System.out.println(set.size());
//		set.clear();
		System.out.println("-----");
		
		
		Set set2 = new HashSet();
		set2.add("aa");
		set2.add("bb");
		
		set.addAll(set2);
		

	}

}
