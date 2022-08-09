package chat.server;

/**
 * 연결한 채팅클라이언트의 메시지 수신 및 응답 처리 스레드
 * @author 이규헌
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatThread extends Thread {
	
	private Socket socket;
	BufferedReader in;
	PrintWriter out;

	public ChatThread(Socket socket) throws IOException {
		this.socket = socket;
		// 소켓의 스트림 열기
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter((socket.getOutputStream()));
	}
	
	public void MessageProcess() throws IOException {
		
		String Message = null;
		
		//서버에서 보낸걸 readLine해서 Message에 할당함.
		while((Message =in.readLine()) != null) {
			
			System.out.println("Client send message: " + Message);
			
			if(Message.equalsIgnoreCase("quit")) {
				break;
			}
			sendMessage(Message);
			
		}
		
	}
	
	//연결한 모든 채팅 클라이언트에게 메시지 전송
	public void sendMessage(String Message) {
		out.println(Message);
		out.flush();
	}


	@Override
	public void run() {
		
		try {
			MessageProcess();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
				try {
					if(socket != null)socket.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
		}

	}
	
		
}
