package namoo.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 표준입력
 * @author Lee KyuHeon
 *
 */
public class StandardInputExample {

	public static void main(String[] args) throws IOException {
		System.out.println(System.in);
		System.out.print("이름을 입력: ");
//		int data = System.in.read();	//1바이트만 읽어옴		
//		System.out.println(data);
		
//		byte[] buffer = new byte[100];
//		int count = System.in.read(buffer);
//		System.out.println(count);
		//a를 입력했을 경우 3바이트가 나옴 왜? 엔터값은 2바이트를 먹기 때문에 a(1바이트) + 엔터<\r\n>(2바이트)
		
		//문자 디코딩 //한글은 꼭 2바이트만 할당되는게 아님! UTF8방식은 2바이트 이상
//		String name = new String(buffer, 0, count-2); //엔터값을 빼야하니까 -2
//		System.out.println(name);
		
		
		InputStreamReader isr = new InputStreamReader(System.in);
//		InputStreamReader은 브릿지 역할을 한다. BufferedReader는 인자로서 reader를 받아야하는데,
//		System.in은 inputStream이다. 그렇기 때문에 InputStreamReader로 system.in을 받아서 reader로 바꾸고 그 값을 bufferedReader에 입력한다.
		BufferedReader br = new BufferedReader(isr);
		String name = br.readLine();
		System.out.println(name);
		
		//아래처럼 한줄에 쓰는게 가능
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		//Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name2 =  sc.nextLine();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.println("몸무게: ");
		double weight = sc.nextDouble();
		System.out.println(name2);
		System.out.println(age);
		System.out.println(weight);
		
		
		
		
		
		
	}
	

}
