package collectionFramework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("111", "Martin");
		map.put("222", "Garicia");
		map.put("333", "Rooney");
		map.put("444", "Martin");
		map.put("444", "Bobobob"); //같은 key일때, value값을 덮어쓰기해버림
		
		System.out.println(map.get("444"));
		map.remove("222");
		
		Set<String> Keys = map.keySet();
		System.out.println(Keys);
		
//		Iterator<String> it = Keys.iterator();
//		while (it.hasNext()) {
//			String string = it.next();
//			System.out.println(string);
//			
//		}
		
		Collection<String> collection =  map.values();
		System.out.println(collection);
		
		Set<Entry<String,String >> entries = map.entrySet();
		System.out.println(entries);
		
		
		
		
	
	}
	
	
	
	
	
	
	
}
