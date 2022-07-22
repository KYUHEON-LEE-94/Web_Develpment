package namoo.standardAPI;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		
		String ymd = "2022-3-13-32-12-23";
		StringTokenizer st = new StringTokenizer(ymd,"-");
		System.out.println(st.countTokens());
		while(st.hasMoreElements()) {
		String token = st.nextToken();
		System.out.println(token);
		}
		
		String[] fe = ymd.split("-");
		
		for (String string : fe) {
			System.out.println(string);;
		}
		

		
		
	}
}
