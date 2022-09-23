package namoo.jdbc;

/**
 * OR-Mapping 클래스 또는 Domain클래스 정의
 *
 */
public class Student {
	private int ssn, korean, english, math;
	private String name;
	
	public Student() {}
	
	public Student(int ssn, int korean, int english, int math, String name) {
		this.ssn = ssn;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.name = name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String str = " [Student] "+"ssn: "+ssn+" name: "+name+" korean: "+korean+" english: "+english+" math: "+math;
		return str;
		
	}
	
	
	
}
