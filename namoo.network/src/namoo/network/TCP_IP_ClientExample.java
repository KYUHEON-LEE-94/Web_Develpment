package namoo.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCP_IP_ClientExample {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1"; //~~ip로 접속
		String Teacher = "192.168.7.101";
		int port = 2022;
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		
		
		try {
			socket = new Socket(serverIp, port);
			System.out.println("서버("+serverIp+")와 연결됨");
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			out.println("안녕 Server");
//			out.flush(); 
			
			String inputMessage = null;
			
			while( (inputMessage =sc.nextLine()) != null) {

			out.println(inputMessage);
			out.flush();
			
			if(inputMessage.equalsIgnoreCase("quit")) {
				break;
			}
			
			//서버로부터 보낸 에코메시지를 받기위해
			String serverMessage = in.readLine();
			System.out.println("서버에서 수신한 메시지: "+serverMessage);
			}
			
		}catch (IOException e) {
			System.out.println("서버를 찾을 수 없습니다.");
		}finally {
				try {
					if(socket != null) socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}

}
