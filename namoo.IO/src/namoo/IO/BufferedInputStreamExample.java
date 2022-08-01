package namoo.IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamExample {
	public static void main(String[] args) {
		
		String path = "D:\\웹개발_이규헌\\Cat.jpg";
		InputStream in = null;
		BufferedInputStream bis = null;
		
		try {
			in = new FileInputStream(path);
//			bis = new BufferedInputStream(in); //buffer size: 512byte
			bis = new BufferedInputStream(in, 1024); //buffer size: 1024byte
			
			bis.mark(0);
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.skip(200);
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.reset();
			System.out.println(bis.read());
			
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
