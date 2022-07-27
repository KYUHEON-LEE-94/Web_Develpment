package namoo.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static Account ar() {
		
		Account as = new Account("12312","efe");
		return as;
	}
	
	public static List<Account> as(){
		List<Account> li = new LinkedList<Account>();
		li.add(0, ar());
		return li;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
	Account as = new Account();
	Map<String, Account> ma = new LinkedHashMap<String, Account> ();
	ma.put("1", new Account("112312","이름"));
	ma.put("2", new Account("112312","이름"));
	ma.put("3", new Account("112312","이름"));
	ma.get(as.getAccountOwner());
	Collection<Account> li = ma.values();
	System.out.println(ma.get(as.getAccountOwner()));
	Iterator<Account> it = li.iterator();
	while (it.hasNext()) {
		Account account = it.next();
		if(account.equals(as.getAccountOwner())) {
			System.out.println(account);
		}
		
	}

	
		
	}
}
