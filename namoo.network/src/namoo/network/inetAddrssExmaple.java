package namoo.network;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 도메인(www.naver.com)을 DNS와 통신을 통해 IP 주소로 변환해 주는 클래스
 * @author Lee KyuHeon
 *
 */

public class inetAddrssExmaple {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost(); //Calneder.getinstance(); 처럼
		System.out.println(ia.getHostAddress());
		
		InetAddress ia2 = InetAddress.getByName("www.naver.com"); //getByName = 도메인 주소
		//DNS 통신이 이루어지면서 실제 ip값을 가져옴
		System.out.println(ia2.getHostAddress());
		
		
		InetAddress[] ia3 = InetAddress.getAllByName("www.google.com"); //복수의 서버를 사용하는 경우가 있어서  []을 통해 확인하는 경우도 있음
		for (InetAddress inetAddress : ia3) {
			System.out.println(inetAddress);
		}
		
	}

}
