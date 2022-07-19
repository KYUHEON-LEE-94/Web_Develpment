package namoo.java;

public class Foo {
	
	public void doTask() {
//		String message = null;
//		char c = message.charAt(0); java.lang.NullPointerException
//		System.out.println(c);
		
//		System.out.println(10/0);   java.lang.ArithmeticException
		
		
		int[] array = {1,3,5,7,8,9};
		System.out.println(array[0]);
		System.out.println(array[3]);
//		System.out.println(array[312]);   java.lang.ArrayIndexOutOfBoundsException
		
	}
	
	public void doTask2() {
		try {
//			String message = null;
//			char c = message.charAt(0); //java.lang.NullPointerException
//			System.out.println(c);
			System.out.println(10/0);
		}catch(NullPointerException e) {
			System.out.println("생성되지 않은 객체의 메소드는 호출할 수 없습니다.");
			
		}catch(ArithmeticException excep) {
			System.err.println("0으로 어케 나누니");
			excep.printStackTrace();
		}
		
		
	}
	
	public void doTask3() {
		try {
//			String message = null;
//			char c = message.charAt(0); //java.lang.NullPointerException
//			System.out.println(c);
			System.out.println(10/0);
		}catch(NullPointerException | ArithmeticException excep) {
			if(excep instanceof NullPointerException) {
				
				System.out.println("예외가 발생했습니다. ");
			}else if(excep instanceof ArithmeticException) {
				System.out.println("예외가 발생했습니다. ");
			}
				
		}
		
	}
	
	public void doTask4() {
		try {
//			String message = null;
//			char c = message.charAt(0); //java.lang.NullPointerException
//			System.out.println(c);
			System.out.println(10/0);
		}catch(Exception exep) {
			if(exep instanceof NullPointerException) {
				
				System.out.println("예외가 발생했습니다. ");
			}else if(exep instanceof ArithmeticException) {
				System.out.println("예외가 발생했습니다. ");
			}			
		}		
	}
	
	public void doTask5() {
		try {
			String message = null;
			char c = message.charAt(0); 
			System.out.println(c);
		}catch(NullPointerException exception) {
			System.out.println("생성되지 않은 객체의 메소드는 호출할 수 없습니다.");
		}catch(ArithmeticException excep) {
			System.out.println("0으로 어케 나누니");
		}finally {
			System.out.println("꼭 실행되어야 하는 중요한 코드 로직");
		}
	}
	
	public void doTask6() {
		try {
			String message = null;
			char c = message.charAt(0); 
			System.out.println(c);
		}finally {
			System.out.println("꼭 실행되어야 하는 중요한 코드 로직");
		}
	}
	
	
}
