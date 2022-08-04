package namoo.thread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DaemonThreadExample {
	//가정: 메모장에 10초마다 자동저장하는 데몬쓰레드를 만든다.
	
	//내부 클래스는 외부클래스 생성하고 생성해야해서, static  사용
	static class SaveFileThread extends Thread{

		@Override
		public void run() {
			String message = "데몬스레드 예제입니다.";
			String path = "Deamon.txt";
			try {
				while(true) {//메인스레드가 끝나면 데몬 스레드도 같이 종료되니까 무한루프 ok
					FileOutputStream fos = new FileOutputStream(path, true);
					PrintWriter out = new PrintWriter(fos, true);
			
				out.print(message); 
				//print가 버퍼가 남아서 flush 사용 혹은 new PrintWriter(fos, true);로 사용
//				out.flush();
				System.out.println("데몬스레드 파일 자동 저장 >>>");
				Thread.sleep(5000);
				out.close();
				}
				
			} catch (FileNotFoundException | InterruptedException e) {

				e.printStackTrace();
			}
		
		}
		
	}

	public static void main(String[] args) {
		System.out.println("--Main Thread Start--");
		
		SaveFileThread daemonThread = new SaveFileThread();
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		try {
			Thread.sleep(15*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("--Main Thread End--");

	}

}
