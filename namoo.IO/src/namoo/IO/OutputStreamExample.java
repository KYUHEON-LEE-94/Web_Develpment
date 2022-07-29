package namoo.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamExample {
	public static void main(String[] args) {
		String path = "example.txt";
		OutputStream out = null;
		
		try {
//			out = new FileOutputStream(path);
			out = new FileOutputStream(path, true);
//			byte data = 97;
//			out.write(data);
			
//			for (int i = 0; i < 128; i++) {
//				out.write(i);
//			}
			
			byte[] buffer = {10, 20, 30, 40, 50};
			out.write(buffer);
			
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
