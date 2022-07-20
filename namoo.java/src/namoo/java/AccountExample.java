package namoo.java;



/*
 * @author Administer
 * 애플리케이션 실행을 위한 애플리케이션 클래스 정의
 * 
 */

public class AccountExample {
	
//	call by value //편한 테스트를 위한 static
	public static void triple(int num) {
		System.out.println(num*3);
		
	}
	
	
//	call by reference	//편한 테스트를 위한 static
	public static void triple(Account account) {
		long money = account.getRestMoney();
		try {
		account.deposit(money*3);
		}catch (InvalidException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(account.getRestMoney());
	}
	
	
	
	

	public static void main(String[] args) {
//	클래스로부터 인스턴스 생성
//	레퍼런스 변수 선언
		Account account;
//	생성자 호출을 이용한 인스턴스 생성
		account = new Account("111-222", "나");

		System.out.println(account.getSerialNum());
		System.out.println(account.getAccountNum());
		System.out.println(account.getAccountOwner());
		System.out.println(account.getPasswd());

//	비밀번호 체크	
		if (account.checkPasswd(1234)) {

// 입금테스트
			long restMoney;
			
			try {
				restMoney = account.deposit(300000);
			} catch (InvalidException e) {
				
				System.err.println(e.getMessage());
			}
			
			try {
				restMoney = account.deposit(0);
				if (restMoney > 0) {
					System.out.println("입금 후 현재 잔액" + restMoney);
				} else {
					System.out.println("똑바로 입력해라...");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

//	출금 테스트
			
			try {
				restMoney = account.withdraw(5000);
				System.out.println("출금 후 현재 금액: " + restMoney);
			}catch(InvalidException e) {
				System.err.println(e.getMessage());
				}
			}
		

		
		Account account2 = new Account("111-333", "너", 1234, 10000000);

		System.out.println(account2.getSerialNum());
		System.out.println(account2.getAccountNum());
		System.out.println(account2.getAccountOwner());
		System.out.println(account2.getPasswd());

		// 입금 테스

		// static변수는 클래스이름.변수명 접근을 권장 for 가독성
		System.out.println(Account.bankName);
		System.out.println(account.bankName);
		
		
		Account account3 = account; //pass by reference    동일한 값을 공유하고 있다.
		
		try {
			System.out.println(account3.deposit(0));
			
		} catch (InvalidException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(account.getRestMoney());
		
		
		
//	call by Test
	int num = 10;
	triple(num);
	System.out.println(num);
	
	System.out.println(account.getRestMoney());
	triple(account);
	System.out.println(account.getRestMoney());
		
	java.util.Date today = new java.util.Date();
	System.out.println(today.toLocaleString());
	java.util.Scanner sc = new java.util.Scanner(System.in);
	

	
	
	}
	
	
		
		}

	


