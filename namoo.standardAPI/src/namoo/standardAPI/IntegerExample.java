package namoo.standardAPI;

public class IntegerExample {
	public static void main(String[] args) {
		String age = "10";
		int age2 = Integer.parseInt(age);
		System.out.println(age2 + 10);
		System.out.println(Integer.toBinaryString(age2));
		System.out.println(Integer.toHexString(age2));
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.max(10,20));
		
	}
}
