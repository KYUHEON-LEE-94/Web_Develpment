package namoo.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 기존 스트림과 달리 양방향 입출력이 가능하고,
 * 임의접근이 가능하고, 자바의 모든 데이터타입별로 읽고 쓸수 있는 기능 제공하는 클래스
 * 스트림클래스가 아니다.
 * 유틸리티 클래스다.
 * 무겁고, 오로지 파일 입출력에만 가능
 * @author Lee KyuHeon
 *
 */

public class RandomAccessFileExample {
	public static void main(String[] args) throws IOException {
		String path = "example4.dat";
		RandomAccessFile raf = new RandomAccessFile(path, "rw");
		long fileSize = raf.length();
		
		if(fileSize == 0) {
			System.out.println("파일이 존재하지 않아 새로운 파일 생성");
		}else {
			System.out.println("파일 사이즈: "+ fileSize);
		}
		
		boolean flag = true;
		char firstName ='김';
		int age = 30;
		double weight = 65.74;
		String profile = "못생긴 넘입니다.";
		
		System.out.println("현재 포인터 위치: " + raf.getFilePointer());
		raf.writeBoolean(flag);
		System.out.println("현재 포인터 위치: " + raf.getFilePointer());
		raf.writeChar(firstName);
		System.out.println("현재 포인터 위치: " + raf.getFilePointer());
		raf.writeInt(age);
		System.out.println("현재 포인터 위치: " + raf.getFilePointer());
		raf.writeDouble(weight);
		System.out.println("현재 포인터 위치: " + raf.getFilePointer());
		raf.writeUTF(profile);
		System.out.println("현재 포인터 위치: " + raf.getFilePointer());
		
		raf.seek(0); 
		//포인터를 0지점(맨앞)으로 이동하고 다시 아래같이 읽어오기
		
		//스트림 닫을 필요가 없음
		flag = raf.readBoolean();
		firstName = raf.readChar();
		age = raf.readInt();
		weight = raf.readDouble();
		profile = raf.readUTF();
		
		
		System.out.println(flag);
		System.out.println(profile);
		
		raf.close();
	}
}
