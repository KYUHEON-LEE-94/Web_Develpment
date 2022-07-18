package namoo.java;

public class AMS {

	public static void main(String[] args) {
		Inventory inventory = new Inventory(30);
		
		//신규계좌 등록
		inventory.open(new Account("1111-2222","이규헌",1234,10000000));
		inventory.open(new MinusAccount("1111-3333","김규헌",134,2321, 12340));
		inventory.open(new Account("2222-5678","박규헌",124,2340000));
		inventory.open(new MinusAccount("1111-234","조규헌",123, 231,345000));
		
		//전체 목록 조회
		Account[] list = inventory.getAccounts();
		
		for(Account account:list) {
			if(account != null) {
//			System.out.println(account.getAccountNum() + "\t" + account.getAccountOwner() + "\t" + "***"+"\t" + account.getRestMoney()+"\t");
//				System.out.println(account.toString());
				System.out.println(account); //자동호출됨
			}
		}
		
		//계좌번호로 검색
		Account findAccount = inventory.find("1234-335433");
		if(findAccount != null) {
			System.out.println(findAccount);
		}else {
			System.out.println("검색된 계좌가 존재하지 않습니다.");
		}
		
		
		
		/**
		 * 예금주명으로 검색
		 * 예시) 이규헌이 3명이라면, 3명다 프린트 될수있게
		 */
		
		public Account[] search(String accountOwner) {
			
			
		}
		
	}

}
