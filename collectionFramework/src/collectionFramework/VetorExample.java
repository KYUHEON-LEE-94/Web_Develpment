package collectionFramework;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

public class VetorExample {

	public static void main(String[] args) {

		
		Vector<String> vector = new Vector<String>(); //동기화 컬렉션 프레임워크
		
		vector.addElement("C");
		vector.addElement("JAVA");
		vector.addElement("HTML");
		vector.addElement("CSS");
		System.out.println(vector.elementAt(1));
		System.out.println(vector.removeElement("HTML"));
		System.out.println(vector.size());
		
		Enumeration<String> e = vector.elements(); //Iterator랑 비슷
		while (e.hasMoreElements()) {
			String string = (String) e.nextElement();
			
		}
		
		

	}

}

