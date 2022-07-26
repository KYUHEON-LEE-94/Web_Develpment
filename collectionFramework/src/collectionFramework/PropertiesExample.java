package collectionFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	
	//static 초기화 블럭
	static {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("sample.properties"));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String name = prop.getProperty("1111");
		String name2 = prop.getProperty("2222");
		
		System.out.println(name);
		System.out.println(name2);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties(); //Map 클래스의 키,밸류가 저장되어있는 메모리에 있는 값을 파일로 저장하고 싶을때 사용
											//hashtable을 extends해서 만들어진게 Properties
//		prop.setProperty("1111", "이규헌");
//		prop.setProperty("2222", "김씨");
//		prop.setProperty("server.port", "8282");
		
//		prop.store(new FileOutputStream("sample.properties"), "주석조석");
//		System.out.println("파일 저장함");
		
//		prop.load(new FileInputStream("sample.properties"));
//		String name = prop.getProperty("1111");
//		String name2 = prop.getProperty("2222");
//		
//		System.out.println(name);
//		System.out.println(name2);
		
		
	}

}
