package namoo.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamExample {

	/**
	 * 자바의 기본데이터타입별로 읽기
	 * @author 이규헌
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = "example3.dat";
		FileInputStream fis = new FileInputStream(path);
		DataInputStream dis = new DataInputStream(fis);
		boolean flag;
		char firstName;
		int age;
		double weight;
		String profile;
		
		flag = dis.readBoolean();
		firstName = dis.readChar();
		age = dis.readInt();
		weight = dis.readDouble();
		profile = dis.readUTF();
		
		dis.close();
		System.out.println(flag);
		System.out.println(firstName);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(profile);
		
		

	}

}
