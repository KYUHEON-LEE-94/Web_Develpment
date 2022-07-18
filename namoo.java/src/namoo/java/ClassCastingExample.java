package namoo.java;


public class ClassCastingExample {

	public static void main(String[] args) {
		
		Account account = new Account();
		
		//up캐스팅(자동 형변환)
		Account account2 = new MinusAccount("999-9999","김마너스",1111,100000, 100000000);
		
		//재정의된 메소드는 호출 가능
		System.out.println(account2.getRestMoney());
		
		//새롭게 추가된 속성이나 메소드는 호출 불가능
		//System.out.println(account2.getBorrowMoney());
		//새롭게 추가된 속성이나 메소드를 호출하기 위해 down casting 필요
		
		MinusAccount ma = (MinusAccount)account2;
		System.out.println(ma.getBorrowMoney());
		
		//instance of
		if(account2 instanceof MinusAccount) {
			MinusAccount ma2 = (MinusAccount)account2;
			System.out.println(ma); 
		}
						
		
		
		
		
		
		
		
	}


		}

	



























