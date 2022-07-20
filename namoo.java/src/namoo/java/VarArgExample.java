package namoo.java;

public class VarArgExample {
	
	@Deprecated
	public static int sum(int...arg) {
		int result =0;
		for (int i : arg) {
			result += i;
		}
		return result;
	}
	
	

	public static void main(String[] args) {

		System.out.println(sum(10,20,30,50,60,708,0));
		
		}
		

		

}
