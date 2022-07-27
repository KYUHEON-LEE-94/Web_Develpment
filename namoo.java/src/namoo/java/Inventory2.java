package namoo.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 은행계좌 목록 관리
 * @author Lee KyuHeon
 *
 */


public class Inventory2 {
	private Map<String, Account> accounts;
	
	
	public Inventory2() {	
		accounts = new LinkedHashMap<String, Account>();
	}
	


	

	
	/**
	 * 전체 계좌 목록 반환
	 * @return 저장된 전체 계좌
	 */
	
	public Collection<Account> getAccounts() {
		return  accounts.values();
		
	}
	
	public int getCount() {
		return accounts.size();
	}

	
	/**
	 * 신규 계좌 등록
	 * @param account 신규계좌
	 */
	public void open(Account account) {

		accounts.put(account.getAccountNum(), account);
		
		
	}
	
	/**
	 * 계좌명으로 계좌검색
	 * @param accountNum 계좌번호
	 * @return 검색된 계좌
	 */
	
	public Account find(String accountNum) {
		return accounts.get(accountNum);
		
	}
	
	/**
	 * 삭제기능
	 */
	public Account remove(String accountNum){
		return accounts.remove(accountNum);
		
	}
	
	
	/**
	 * 예금주명으로 검색
	 * @param accountOwner
	 * @return
	 */
	
	public List<Account> search(String accountOwner) {
		List<Account> searchList = new ArrayList<>();  //추가 삭제없이 목록만 전달하면 되니까,
		Collection<Account> values = accounts.values();
		Iterator<Account> iter = values.iterator();
		
		while (iter.hasNext()) {
			Account account = iter.next();
			if(account.getAccountOwner().equals(accountOwner)) {
				searchList.add(account);
				
			}
		}
		return searchList;
		
		
		}
		

		
	

	
	
	
	
	}
	
	

	

