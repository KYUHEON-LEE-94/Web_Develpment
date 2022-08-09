package namoo.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private Socket socket = null;
	

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void echo() throws IOException {
		
		
		// 소켓의 스트림 열기
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter((socket.getOutputStream()));

		
		String clientMessage = null;
		
		while((clientMessage =in.readLine()) != null) {
			
			System.out.println("클라이언트 전송 메시지: " + clientMessage);
			
			if(clientMessage.equalsIgnoreCase("quit")) {
				System.out.println(socket.getInetAddress().getHostAddress()+"가 종료했습니다.");
				break;
			}
			
			// 클라이언트에게 에코
			out.println(clientMessage);
			out.flush();
			
		}
		
	}


	@Override
	public void run() {
		
		try {
			echo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(socket != null)socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
	
		
}
