package namoo.thread;

public class ThreadExample {

	public static void main(String[] args) {
		System.out.println("--Main Thread Start--");
		System.out.println("Main Thread Task 1");
		System.out.println("Main Thread Task 2");
		
		//Main Thread와 별개로 동작하는 스레드 생성 및 실행
		HelloThread thread = new HelloThread("뚜레",10);
//		thread.run(); 이렇게 호출하면 안됨
		thread.start();
		
		HelloThread thread2 = new HelloThread("뚜레2",10);
		thread2.start();
		
		//Implements Run의 경우
		HelloThread2 thread3 = new HelloThread2(10);
		Thread t = new Thread(thread3, "규헌");
		t.start();
		
		//다른 경우
		Thread HelloThread21 = new Thread(new HelloThread2(10));
		
		
		System.out.println("--Main Thread End--");

	}

}
