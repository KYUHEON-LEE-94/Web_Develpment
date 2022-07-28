package namoo.awt;

public enum Accounts {
	
	
	ALL("전체계좌"), Account("입출금계좌"), MINUSACCOUNT("마이너스계좌"), STOCKACCOUNT("주식 계좌");

	String name;
	
	Accounts(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
}


