package namoo.ams;

/*
 * @author 이규헌
 * 은행계좌 추상화 클래스
 */

public class Account {
	public static String bankName = "Korea IT Bank";
	
 
	
	//인스턴스 변수
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	private int serialNum = 1;
	
	
	
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
