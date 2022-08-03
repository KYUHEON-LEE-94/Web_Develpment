package namoo.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class ObjectStreamExample {
	
	public static void writeObject() throws IOException {
//		Calendar today = Calendar.getInstance();
		Account account = new Account("111-5555","나라는 사람",1234,10000);
		FileOutputStream fos = new FileOutputStream("example6.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//객체직렬화 & 스트림
		oos.writeObject(account);
		oos.close();
		System.out.println("파일 저장 완료");
		
		
	}
	
	public static void readObject() throws IOException, ClassNotFoundException {
//		Calendar today;
		Account account;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example6.ser"));
		
		
//		today =(Calendar)ois.readObject();
		account = (Account) ois.readObject();
		ois.close();
//		System.out.printf("%1$tF %1$tT",today);
		System.out.println(account.toString());
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		writeObject();
		readObject();
		

	}

}
