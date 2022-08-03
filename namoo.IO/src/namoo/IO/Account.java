package namoo.IO;

import java.io.Serializable;

/*
 * @author 이규헌
 * 은행계좌 추상화 클래스
 */

//Serializable 내부에는 아무런 메소드가 없다. -> 마킹 인터페이스
public class Account implements Serializable {
	// 스태틱변수(인스턴스들이 공유하기 위한 목적)
	public static String bankName = "Korea IT Bank";
	private static int Num = 1;
	
//	스태틱 초기화 블록
	static {
		//주로 애플리케이션 환경 변수 초기화에 사용
		//new FileInputStream(new File("C:/xxx/yyy/config.conf"));
	}
	
//	스태틱 메소드
	
	public static int getNum() {
		return Num;
	}
	
	
	

	
	//상수
	public static final int MAX_MONEY = 100000000;
	
	 
	
	//인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	private int serialNum = 1;
	
	
	//초기화 블록
	{
		this.serialNum = Num++;
	}

	
	public Account() {
		this(null,null);
		
	}

	public Account(String accountNum, String accountOwner) {
		this(accountNum, accountOwner, 0, 0);

	}

	public Account(String accountNum, String accountOwner, int passwd) {

		this(accountNum, accountOwner, passwd, 0);
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		

		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

// 	디폴트 생성자(컴파일시 명시저그로 작성하지 않으면 자동 생성)
//	public Account() {	}
	
	
	
//	Setter, Getter 인스턴스 메소드----
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getAccountNum() {
		return accountNum;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getPasswd() {
		return passwd;
	}

	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	public long getRestMoney() {
		return restMoney;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}
	
	
	
	
	//-------------------
	
	@Override
	public String toString() {
		return getAccountNum()+"\t"+getAccountOwner()+"\t****\t"+getRestMoney();
	}
	
	

	/**
	 * 현재 은행계좌에 입금
	 * @param money 입금 금액
	 * @return 입금 후 잔액
	 */
	
	//throws를 이용한 예외 간접 처리(예외 던지기)
	//계좌 관련 기능 인스턴스 메소드
	//입금
	public long deposit(long money) throws InvalidException{
		
		if(money <= 0) {
			throw new InvalidException("입력하고자 하는 금액은 0이거나 음수일 수 없습니다.");
		}
		
		restMoney += money;
		return restMoney;
		
	}
	
	//출금
	public long withdraw(long money) throws InvalidException{
		
		if(money <= 0) {
			throw new InvalidException("입력하고자 하는 금액은 0이거나 음수일 수 없습니다.");
		}
		
		if(restMoney < money) {
			throw new InvalidException("출금하고자 하는 잔액이 부족합니다.");
		}
		restMoney -= money;
		
		return restMoney;
		
	}
	
//	비밀번호 체크
	public boolean checkPasswd(int passwd) {
		
		return passwd == this.passwd;
		
	}
	
	
	
	

}
