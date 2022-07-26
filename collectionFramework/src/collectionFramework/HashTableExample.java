package collectionFramework;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTableExample {
	public static void main(String[] args) {
		Hashtable<String, String> table = new Hashtable<String, String>(); //동기화 가능
		table.put("111", "Martin");
		table.put("222", "Garicia");
		table.put("333", "Rooney");
		table.put("444", "Martin");
		table.put("444", "Bobobob"); //같은 key일때, value값을 덮어쓰기해버림
		
		System.out.println(table.get("444"));
		table.remove("222");
		
		Enumeration<String> e = table.keys();
		while (e.hasMoreElements()) {
			String string = e.nextElement();
			System.out.println(string);
			
		}
		
		Enumeration<String> en = table.elements();
		System.out.println(en);
		
		
		
		
	
	}
	
	
	
	
	
	
	
}
