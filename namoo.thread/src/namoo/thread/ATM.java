package namoo.thread;

public class ATM {
	/** 테스트를 위한 공유 계좌 */
	Account account = new Account("1111-2222", "방그리가족통장", 1111, 100000);

	/** 입금 */
	public void depositMoney(String accountNum, int passwd, long money, String user) throws Exception {
		System.out.println("***** " + user + " 입금 시작 *****");
		// 본점 서버와의 통신에 약간의 시간이 소요된다 가정..
		Thread.sleep(500);
		account.deposit(money);
		Thread.sleep(500);
		System.out.println(user + " 입금 후 잔액 : " + account.getRestMoney());
		System.out.println("***** " + user + " 입금 완료 *****");
	}

	/** 출금 */
	public void withdrawMoney(String accountNum, int passwd, long money, String user) throws Exception {
		System.out.println("***** " + user + " 출금 시작 *****");
		if (money > account.getRestMoney()) {
			throw new InvalidException("-> 잔액이 부족합니다.");
		}
		// 본점 서버와의 통신에 약간의 시간이 소요된다 가정..
		Thread.sleep(500);
		account.withdraw(money);
		Thread.sleep(500);
		System.out.println("->" + user + " 출금 후 잔액 : " + account.getRestMoney());
		System.out.println("***** " + user + " 출금 완료 *****");
	}
	
	
	
	
}
