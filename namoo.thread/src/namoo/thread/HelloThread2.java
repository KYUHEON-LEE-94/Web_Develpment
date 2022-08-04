package namoo.thread;

import java.util.Iterator;

public class HelloThread2 implements Runnable {

	private int count;

	public HelloThread2(int count) {
		this.count = count;
	}
	
	/**사용자 스레드의 Entry Point 역할 메소드*/
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-- 스레드 시작--");
		
		for (int i =0; i<count; i++) {
			System.out.println(Thread.currentThread().getName()+": " + i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
			Thread.yield();
			
		}
		System.out.println(Thread.currentThread().getName()+"-- 스레드 종료--");
	}
	
	
	
}
