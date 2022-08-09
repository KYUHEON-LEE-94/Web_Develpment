package chat.server;

import java.io.IOException;

public class NamooChatServer {
	public static void main(String[] args) {
		try {
			ChatService chatService = new ChatService();
			System.out.println("===ChatServer("+ChatService.PORT+") Start===");
			chatService.connectListening();
			
		} catch (IOException e) {
			System.err.println("포트충돌("+ChatService.PORT+")로 서버를 구동할 수 없습니다.");
		}

	}

}
