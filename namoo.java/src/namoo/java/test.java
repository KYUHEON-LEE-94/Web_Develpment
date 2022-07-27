package namoo.java;

public class test {
	public static void main(String[] args) {
		Inventory2 inventory = new Inventory2();
		
		//신규계좌 등록
		inventory.open(new Account("1111-2222","이규헌",1234,10000000));
		inventory.open(new MinusAccount("1111-3333","이규헌",134,2321, 12340));
		inventory.open(new Account("2222-5678","이규헌",124,2340000));
		inventory.open(new MinusAccount("1111-234","김규헌",123, 231,345000));
		
		
	
		
		System.out.println(inventory.getAccounts());
		
		
		
	}
}
