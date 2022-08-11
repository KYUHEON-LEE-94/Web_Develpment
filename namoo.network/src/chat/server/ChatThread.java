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
	private ChatService chatService;

	public ChatThread(Socket socket, ChatService chatService) throws IOException {
		this.socket = socket;
		this.chatService = chatService;
		// 소켓의 스트림 열기
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter((socket.getOutputStream()));
	}
	
	public void MessageProcess() throws IOException {
		
		String Message = null;
		
		//서버에서 보낸걸 readLine해서 Message에 할당함.
		while((Message =in.readLine()) != null) {
			
			System.out.println("Client send message: " + Message);
			String[] tokens = Message.split("!");
			String MessageType = tokens[0];
			String senderNickname = tokens[1]; //nickname
			
			switch (MessageType) {
			case "CONNCECT": //최초 입장
				chatService.addClient(senderNickname, this); //최초 입장했을 때 key로 닉네임을 등록하고, 스레드를 등록한다. 그리고 sendall
				chatService.sendAllMessage(Message); //원래의 원형 메시지를 그대로 보낸다.
				//현재 참여한 모든 클라이언트 리스트 전송
				chatService.sendAllMessage("USERLIST!"+senderNickname+"!"+chatService.getNicknameList());
				break;
			case "CHAT": //채팅메시지
				chatService.sendAllMessage(Message);
				break;
				
			case "DM!":	
				String receivename = tokens[2];
				String receiveMessage = tokens[3];
				chatService.findClient(receivename, receiveMessage);

				break;
			case "DISCONNECT": //퇴장-접속 끊기
				chatService.removeClient(senderNickname); //Client 켈렉션에서 this 스레드를 제거
				chatService.sendAllMessage(Message); //메세지를 보내고
				chatService.sendAllMessage("DELETE!"+senderNickname);
				return; //해당 MessageProcess()메서드 자체를 빠져나가면서 스레드 자체를 종료
			}
			
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
