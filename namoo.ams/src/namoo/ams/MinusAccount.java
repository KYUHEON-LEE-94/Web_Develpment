package namoo.ams;

public class MinusAccount extends Account{

	// 속성 추가
	private long borrowMoney;
	
	public MinusAccount() {}

	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}


	//메소드 추가
	
	public long getBorrowMoney() {
		return borrowMoney;
	}
	
	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}


	
	
	
	//메소드 재정의(Overriding)
	
	@Override
	public String toString() {
		return super.toString() + "\t" + getBorrowMoney();
	}

	@Override
	public long getRestMoney() {
		
		return super.getRestMoney() - getBorrowMoney();
	}
	
	

}
