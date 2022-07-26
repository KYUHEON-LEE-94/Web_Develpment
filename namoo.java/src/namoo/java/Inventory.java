package namoo.java;

/**
 * 은행계좌 목록 관리
 * @author Lee KyuHeon
 *
 */


public class Inventory {
	private Account[] accounts;
	private int count;
	
	
	public Inventory(int capacity) {	
		accounts = new Account[capacity];
	}
	
	public Inventory() {
		this(100);
	}

	
	public Account[] getAccounts() {
		return accounts;
	}

	
	/**
	 * 전체 계좌 목록 반환
	 * @return 저장된 전체 계좌
	 */
	public int getCount() {
		return count;
	}

	
	/**
	 * 신규 계좌 등록
	 * @param account 신규계좌
	 */
	public void open(Account account) {

		accounts[count++] = account;
		
		
	}
	
	/**
	 * 계좌명으로 계좌검색
	 * @param accountNum 계좌번호
	 * @return 검색된 계좌
	 */
	
	public Account find(String accountNum) {
		for (int i = 0; i < count; i++) {
			Account account = accounts[i];
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		return null;
	}
	
	public Account findName(String accountOwner) {
		Account[] list = new Account[accounts.length];
		for (int i = 0; i <count; i++) {
			if(accounts[i].getAccountOwner().equals(accountOwner)) {
				list[i] = accounts[i];
				for (Account account : list) {
					System.out.println(list[i]);
					break;
				}
				}
			
			}
		return null;
		}
	
	
	
	
	}
	

	

