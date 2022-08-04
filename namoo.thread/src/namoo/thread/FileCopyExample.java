package namoo.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyExample {
	public static void main(String[] args) throws IOException {
		
		//이름 없는 지역 내부 클래스 활용
		new Thread() {

			@Override
			public void run() {
				
				String srcpath = "D:\\웹개발_이규헌\\workspace\\namoo.IO\\example.txt";
				String destPath = "D:\\웹개발_이규헌\\workspace\\namoo.IO\\example2.txt";
				
				File srcfile = new File(srcpath);
				InputStream in = null;
				OutputStream out = null;
				if(srcfile.exists()){
					
					try {
						in= new FileInputStream(srcpath);
						out = new FileOutputStream(destPath);
						
						byte[] buffer = new byte[4*1024];
						int count = 0;
						
						while((count = in.read(buffer)) != -1) {
							out.write(buffer, 0, count); //맨 마지막에 남은 바이트만큼만 써야하기때문에 offset을 사용하여 조건 범위를 설정해줌
							
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						
						try {
							System.out.println(srcfile.length() + "byte 파일 복사완료");
							if(out != null)out.close();
							if(in != null)in.close();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}else {
					System.out.println("복사 불가");
				}
				
			}
			
			
		}.start();
		

		
		
		
	}
}
