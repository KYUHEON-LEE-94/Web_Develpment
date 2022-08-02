package namoo.IO;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;

public class PrintStreamExample {

	/**
	 * 자바의 기본데이터타입을 문자열로 현변환하여 출력
	 * @author 이규헌
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = "example4.txt";
		PrintStream ps = new PrintStream(path);
		boolean flag = true;
		char firstName ='김';
		int age = 30;
		double weight = 65.74;
		String profile = "못생긴 넘입니다.";
		
		ps.println(flag);
		ps.println(firstName);
		ps.println(age);
		ps.printf("내 몸무게는 %,.1f\n",weight);
		

		System.out.println("파일 저장 완료");
		
		//표준 출력에서 사용하는 out은 printStream 객체이다.
		System.out.println(System.out);
		
		 Properties prop= System.getProperties();
		 Enumeration<Object> keys = prop.keys();
		while(keys.hasMoreElements()) {}
			String key = (String) keys.nextElement();
			String value = (String) prop.get(key);
			System.out.println(key +":" + value);
	}

}
