package namoo.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IP 기반의 Server Program
 * 
 * @author Lee KyuHeon
 */
public class TCP_IP_ServerExample {
	public static void main(String[] args) throws IOException {

		int port = 2022;
		ServerSocket serverSocket = new ServerSocket(port); // 이 서버는 몇번 포트를 사용할 것이냐.
		// 원격 클라이언트 연결을 수신
		System.out.println("서버 구동됨..");

		while (true) {
			// 종단점은 socket이다.
			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress().getHostAddress() + " 클라이언트 접속해옴..");
			//thread를 사용해서 다중 접속을 허용가능하게 만들어줌
			ServerThread thread = new ServerThread(socket);
			thread.start();
			

		}

	}
}
