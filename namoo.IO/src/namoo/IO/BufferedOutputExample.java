package namoo.IO;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedOutputExample {
	public static void main(String[] args) {
		String path = "example2.txt";
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			out = new FileOutputStream(path);
			bos = new BufferedOutputStream(out);
			
			byte[] buffer = {10, 20, 30, 40, 50};
			bos.write(buffer); //메모리에 출력
			bos.flush(); //파일에 출력
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(out != null) out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		 
		
	}
}
