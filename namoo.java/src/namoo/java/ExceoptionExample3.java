package namoo.java;

public class ExceoptionExample3 {
	public static void main(String[] args) {
		
		
		Account account = new Account("1111","김기정",111,100);
			long money = account.deposit(1000);
//			money = account.deposit(0);
			System.out.println("입금 후 잔액: " + money);
			money = account.withdraw(500);
			System.out.println("출금 후 잔액"+ money);
			account.withdraw(3000);
		
			
		
	}
}
