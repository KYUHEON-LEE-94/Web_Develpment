package namoo.java;

import java.util.Set;

/**
 * Generic 클래스 만들기
 * @author Lee KyuHeon
 *
 */

public class Student<T> {
	private T ssn;
	private String name;
	
	public Student() {}

	public Student(T ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}

	public T getSsn() {
		return ssn;
	}

	public void setSsn(T ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	public static void main(String[] args) {
		Student<Integer> student = new Student<Integer>(10, "김기정");
		//제너릭에는 Wrapper Class타입으로만 넣을수잇음
		
		System.out.println(student.getName()); 
		
		Set<String>set;
		
	}
	
	
}
