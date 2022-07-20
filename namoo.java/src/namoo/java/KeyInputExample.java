package namoo.java;

import java.io.IOException;

public class KeyInputExample {
	public static void main(String[] args) {
	
		try {
			int value = System.in.read();
			System.out.println(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
