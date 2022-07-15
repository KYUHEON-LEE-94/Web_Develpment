package namoo.java;


public class AccountExample2 {

	public static void main(String[] args) {
		
		MinusAccount ma = new MinusAccount("999-9999","김마이너스",1111,100000, 100000000);
		
		//부모 어카운트의 메소드를 재사용하는 ing
		ma.deposit(1000);
		//부모 메소드 오버라이딩
		System.out.println(ma.getRestMoney());
		
		System.out.println(ma.getBorrowMoney());
		
		
		
		
		
						
		
		
		
		
		
		
		
	}


		}

	



























