package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

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
			ChatThread chatThread = new ChatThread(socket);
			Clients.put("nickname", chatThread);
			chatThread.start();
		}
	}
	
	
	
}
