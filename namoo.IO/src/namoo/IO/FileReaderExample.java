package namoo.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		String path = "src/namoo/io/BufferedInputStreamExample.java";
		
		FileReader fr = new FileReader(path);
//		System.out.println((char)fr.read());
		
//		char[] buffer = new char[1024];
//		int count = 0;
//		while((count=fr.read(buffer)) != -1) {
//			String str = new String(buffer);
//			System.out.println(str);
//		}
		
		//== 위가 아래의 BufferedReader와 같음
		
		BufferedReader br = new BufferedReader(fr);
		String line;
		int number = 0;
		while ((line = br.readLine()) != null) {
			number++;
			System.out.println(number + ":"+line);			
		}
		
	}

}
