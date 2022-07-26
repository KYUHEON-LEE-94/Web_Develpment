package namoo.java;

import java.util.Formatter;

/**
 * 출력형식 지정하여 출력하기
 * @author Lee KyuHeon
 *
 */

public class FormatterExample {
	public static void main(String[] args) {
		int number = 12345678;
		System.out.println(number);
		Formatter formatter = new Formatter();
		formatter.format("%,-20d", number);
		System.out.println(formatter);
		
		double num = 12345.456852;
		System.out.printf("이게 편안함이지- %,-20.2f",num);
		
		String name = "나는너 너와나";
		
		String fs = String.format("%-10s", name);
		System.out.println(fs);
		
		System.out.printf("%d", number);
		
		System.out.println(String.format("%+,20d", 3213));
		
		
		
		
	}
	
	
}
