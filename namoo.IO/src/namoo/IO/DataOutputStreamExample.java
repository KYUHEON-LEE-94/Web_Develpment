package namoo.IO;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {

	/**
	 * 자바의 기본데이터타입별로 쓰기
	 * @author 이규헌
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = "example3.dat";
		FileOutputStream fos = new FileOutputStream(path);
		DataOutputStream dos = new DataOutputStream(fos);
		boolean flag = true;
		char firstName ='김';
		int age = 30;
		double weight = 65.74;
		String profile = "못생긴 넘입니다.";
		
		dos.writeBoolean(flag);
		dos.writeChar(firstName);
		dos.writeInt(age);
		dos.writeDouble(weight);
		dos.writeUTF(profile);
		
		dos.close();
		System.out.println("파일 저장 완료");
		
		

	}

}
