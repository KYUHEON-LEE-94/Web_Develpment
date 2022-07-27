package namoo.java;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AMS2 {

	public static void main(String[] args) {
		Inventory2 inventory = new Inventory2();
		
		//신규계좌 등록
		inventory.open(new Account("1111-2222","이규헌",1234,10000000));
		inventory.open(new MinusAccount("1111-3333","이규헌",134,2321, 12340));
		inventory.open(new Account("2222-5678","이규헌",124,2340000));
		inventory.open(new MinusAccount("1111-234","김규헌",123, 231,345000));
		inventory.open(new MinusAccount("1111-234","이규헌",123, 231,345000));
		inventory.open(new MinusAccount("1111-234","박규헌",123, 231,345000));
		
		//전체 목록 조회
		Collection<Account> list = inventory.getAccounts();
		Iterator<Account> iter = list.iterator();
		while (iter.hasNext()) {
			Account account = iter.next();
			System.out.println(account);
			
		}
		
//		for(Account account:list) {
//			if(account != null) {
//			System.out.println(account.getAccountNum() + "\t" + account.getAccountOwner() + "\t" + "***"+"\t" + account.getRestMoney()+"\t");
//				System.out.println(account.toString());
//				System.out.println(account); //자동호출됨
//			}
//		}
		
		//계좌번호로 검색
		Account findAccount = inventory.find("1111-2222");
		if(findAccount != null) {
			System.out.println(findAccount);
		}else {
			System.out.println("검색된 계좌가 존재하지 않습니다.");
		}
		
		//계좌번호로 삭제
		Account removeAccount = inventory.remove("1111-2222");
		System.out.println(removeAccount.getAccountNum()+"계좌가 삭제되었습니다.");
		
		
		/**
		 * 예금주명으로 검색
		 * 예시) 이규헌이 3명이라면, 3명다 프린트 될수있게
		 */
		
		
		//예금주 검색
		List<Account> sl = inventory.search("이규헌");
		if (sl.isEmpty()) System.out.println("해당 계좌가 존재하지 않습니다.");
		else System.out.println(sl);
	
	}

}
