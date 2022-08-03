package namoo.thread;

import java.util.Iterator;

public class HelloThread extends Thread {

	private int count;

	public HelloThread(String name, int count) {
		super(name);
		this.count = count;
	}
	
	/**사용자 스레드의 Entry Point 역할 메소드*/
	@Override
	public void run() {
		System.out.println(getName()+"-- 스레드 시작--");
		
		for (int i =0; i<count; i++) {
			System.out.println(getName()+": " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		System.out.println(getName()+"-- 스레드 종료--");
	}
	
	
	
}
