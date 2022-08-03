package namoo.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class FileWriterExample {
	public static void main(String[] args) throws IOException {
		
		String path = "example5.txt";
		FileWriter fw = new FileWriter(path);
//		BufferedWriter bw = new BufferedWriter(fw);
		//BufferedWriter는 메모리에 먼저 써놓음(효율적으로 쓰기 위해 사용 그 외의 기능은 없음)
		
//		bw.write("하이");
		
		//다양한 예시
		PrintWriter pw = new PrintWriter(path);
//		PrintWriter pw = new PrintWriter(new File(path));
//		PrintWriter pw = new PrintWriter(fw);
		pw.print(true);
		pw.println("안녕하세요");
		pw.printf("%1$tF %1$tT", Calendar.getInstance());
		pw.close();
		
	}
}
