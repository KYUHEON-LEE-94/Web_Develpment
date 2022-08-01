package namoo.IO;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;

/**
 * 파일 관련 정보 및 제어를 위한 File 클래스
 * @author Lee KyuHeon
 *
 */

public class FileExample {
	
	public static void fileExmaple() throws MalformedURLException {
		//상대경로
		String path ="text.txt";
		//절대 경로
//		String path= "D:\\웹개발_이규헌\\workspace\\namoo.IO\\text.txt";
	
		File file = new File(path);
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.length());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(file.lastModified());
		System.out.printf("파일 수정 날짜: %1$tF %1$tT \n",cal);
		System.out.println("파일 존재 여부"+file.exists());
		System.out.println(file.toURL());
	}
	
	
	public static void fileExmaple2() {

		String path ="D:\\웹개발_이규헌\\workspace";
		
		File file = new File(path);
		
//		System.out.println(file.isDirectory());
//		System.out.println(file.isFile());
		
		File[] list = file.listFiles();
		for (File file2 : list) {
			if(file2.isDirectory()) {
				System.out.println("<Dir>"+file2.getName());
			}else {
				System.out.println(file2.getName()+""+file2.length());
			}
		}
		
		
	}
	
	public static void fileExmaple3() throws IOException {
		
		String path = "imsi";
		File file = new File(path);
		System.out.println("디렉터리 생성 여부 "+file.mkdir());
//		System.out.println("삭제 여부" + file.delete());
		file.renameTo(new File("임시"));
		
		File newfile = new File("임시/temp.txt");
		System.out.println(newfile.createNewFile());
		

		
	}
	
	
	
	 
	public static void main(String[] args) throws IOException {
		
//		fileExmaple();
//		fileExmaple2();
//		fileExmaple3();
		
		File[] drives = File.listRoots();
		for (File file2 : drives) {
			System.out.println(file2.toString());
		}
		
		
	}
}
