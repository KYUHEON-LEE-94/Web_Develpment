package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * CharClient의 연결 수신 및 응답 처리 서비스
 * @author Lee KyuHeon
 *
 */
public class ChatService {
	
	public static final int PORT = 2022;
	private boolean running;
	private ServerSocket serverSocket;
	
	//chatThread를 모아놓는 콜렉션 프레임워크
	private Map<String, ChatThread> Clients;
	
	public ChatService() throws IOException {
		serverSocket = new ServerSocket(PORT);
		running = true; //해당 소켓의 port가 잘 열렸다는 것은 서버 동작에 문제가 없다는 의미가 되니까 이때, true로 바꿔준다.
		Clients = new LinkedHashMap<String, ChatThread>();
	
	}
	
	public void connectListening() throws IOException {
		while(running) {
			Socket socket = serverSocket.accept();
			System.out.println("ChatClient ["+socket.getInetAddress().getHostAddress()+"] Connected..");
			ChatThread chatThread = new ChatThread(socket, this);
			chatThread.start();
		}
	}
	
	//접속자 리스트에 접속 클라이언트 추가
	public void addClient(String nickName, ChatThread chatThread) {
		Clients.put(nickName, chatThread);
		
	}
	
	//DM을 보내기 위한 특정한 클라이언트를 찾음
	public void findClient(String nick, String message) {
		ChatThread sender = Clients.get(nick);
		sender.sendMessage("DM!"+ message);
		
	}
	
	
	//접속자 리스트에서 클라라이언트 제거
	public void removeClient(String nickName) {
		Clients.remove(nickName);
		
	}
	
	
	/**모든 접속자에게 메시지를 전송하는 기능
	 */
	public void sendAllMessage(String message) {
		Collection<ChatThread> list = Clients.values();
		Iterator<ChatThread> iter = list.iterator();
		while (iter.hasNext()) {
			ChatThread chatThread = (ChatThread) iter.next();
			chatThread.sendMessage(message);
		}
	}
	
	
	//접속자 닉네임리스트 반환
	public String getNicknameList() {
		Set<String> keys = Clients.keySet();
		if(keys.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String nickname = (String) iter.next();
			sb.append(nickname+",");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
}
