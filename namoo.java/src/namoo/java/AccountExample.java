package namoo.java;

/*
 * @author Administer
 * 애플리케이션 실행을 위한 애플리케이션 클래스 정의
 * 
 */

public class AccountExample {

	public static void main(String[] args) {
//	클래스로부터 인스턴스 생성
//	레퍼런스 변수 선언
	Account account;
//	생성자 호출을 이용한 인스턴스 생성
	account = new Account("111-222","나");
	
	Account account2 = new Account("111-333","너",1234,10000000);
	

	}

}
