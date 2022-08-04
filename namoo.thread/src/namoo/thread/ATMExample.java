package namoo.thread;

public class ATMExample {

	static ATM atm = new ATM();

	public  static void example1() {
		new Thread() {

			@Override
			public void run() {
				
					try {
						while(true) {
						synchronized (atm.account) {
							atm.withdrawMoney("1111-2222", 1111, 1000, "아빠");	
							//synchronized를 공유 매체에다가 걸면 해당 공유매체가 유연하지 않을 수 있음.
							//-> 따라서 해당 매체를 사용하는 쪽에서 synchronized로 락을 걸어서 사용할 수 있음
						 }
										
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		

		}.start();
		
		new Thread() {

			@Override
			public void run() {
				
					try {
						while(true) {
							synchronized (atm.account) {
								atm.withdrawMoney("1111-2222", 1111, 10000, "딸");	
							 }
							}
					} catch (Exception e) {
	
						e.printStackTrace();
					}
				

			}

		}.start();

	}

	public static void main(String[] args) {
		example1();
	}
}
