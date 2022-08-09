package chat.client;
/**
 * 채팅서버와 통신을 담당하는 역할의 클래스
 * @author Lee KyuHeon
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	public static final String SERVER_IP = "localhost";
	public static final int SERVER_PORT = 2022;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	private ChatPanel chatpanel;
	
	public ChatClient(ChatPanel chatpanel) throws UnknownHostException, IOException {
		this.chatpanel = chatpanel;
		
		socket = new Socket(SERVER_IP, SERVER_PORT);
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		}
	
	//채팅 메시지를 서버에 전송
	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}
	
	//채팅 메시지를 서버에서 수신
	public void receiveMessage() {
		
		new Thread() {

			@Override
			public void run() {
				String message = null;
				try {
					
					while((message =in.readLine()) != null) {
						chatpanel.appendMessage(message);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}//run()
			
			
		}.start();
		
	}
	


	
	
	
	
}
