package namoo.java;

/*
 * @author 이규헌
 * 은행계좌 추상화 클래스
 */

public class Account {
//인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	public Account() {
//		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNum, String accountOwner) {
		super();
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		super();
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// 디폴트 생성자(컴파일시 명시저그로 작성하지 않으면 자동 생성)
//	public Account() {	}

}
