package namoo.thread;

import java.util.Iterator;
import java.util.Random;

public class Car extends Thread {

	

	public Car(String name) {
		super(name);

	}

	
	
	@Override
	public void run() {
		System.out.println(getName()+"자동차 시작--");
		
		for (int i =1; i<= 100; i++) {
			System.out.println(getName()+"자동차" + i+"m 전진");
			try {
				int sleepTime = (int)(Math.random()*500);
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		System.out.println(getName()+"자동차 도착--!");
	}
	
	
	
}
