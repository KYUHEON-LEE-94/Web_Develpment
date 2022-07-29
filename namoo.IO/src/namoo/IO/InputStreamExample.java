package namoo.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	public static void main(String[] args) {
		String path = "D:\\웹개발_이규헌\\Cat.jpg";
		InputStream in = null;
		
		try {
			in = new FileInputStream(path);
			int count = in.available();
			System.out.println(count);
			
			
//			int data = in.read();
//			System.out.println(data);
//			int data;
//			while ((data = in.read()) != -1) {
//				System.out.println(data);
//				
//			}
			
			byte[] buffer = new byte[4*1024];
//			int readCount = in.read(buffer);
//			System.out.println(readCount);
			int readcount = 0;
			while((readcount = in.read(buffer)) != -1) {
				for (byte b : buffer) {
					System.out.println(b);
				}
			}
			System.out.println("파일 데이터 다 읽음");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		 
		
	}
}
