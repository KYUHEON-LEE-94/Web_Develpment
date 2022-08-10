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
import java.util.Iterator;

public class ChatClient {
	public static final String TEACHER = "192.168.7.101";
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
						System.out.println("서버 메시지: " + message);
						String[] tokens = message.split("!");
						String MessageType = tokens[0];
						String senderNickname = tokens[1];
						switch (MessageType) {
						case "CONNCECT": //최초 입장
							chatpanel.appendMessage("★★★★"+senderNickname+"님이 대화방에 최초 입장하였습니다.★★★★");
							break;
							
						case "USERLIST": //접속자 리스트
							if(tokens.length <3) {
								chatpanel.appendUserItem(senderNickname);
							}else {
								//user1,user2;
								if(tokens[0] != null) {
								for (int i =0; i<tokens.length; i++) {
									String userList = tokens[i+1];
										chatpanel.appendUserItem(userList);	
									}
									
								}
							}

							break;
						case "CHAT": //채팅메시지
							String chatMessage = tokens[2]; //위에 선언을 해버리면, chatThread에서는 파싱하지 않았기 때문에 NullPontException 발생
							//그러므로, 공통적으로 사용하는 2개만 위에서 공통적으로 선언하고, 따로 사용되는 파싱문구는 아래에서 따로따로 사용
							chatpanel.appendMessage("["+senderNickname+"]: "+chatMessage);
							break;
							
						case "DISCONNECT": //퇴장-접속 끊기
							chatpanel.appendMessage("###"+senderNickname+"님이 대화방에서 나갔습니다.###");
							break; 
							
							
						}
					}
					
				} catch (IOException e) {

				}
			}//run()
			
			
		}.start();
		
	}
	
	//Socket닫는 메서드
	public void close() {
		if(socket != null)
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	
	
	
}
