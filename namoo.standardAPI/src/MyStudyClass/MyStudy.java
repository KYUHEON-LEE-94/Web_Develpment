package MyStudyClass;

import java.util.StringTokenizer;

public class MyStudy {
	public static void main(String[] args) {
		//StringBuffer: 자체 문자열을 편집할 수 있음.
				StringBuffer stringb = new StringBuffer("java");
				stringb.append("script");
				System.out.println(stringb);
				stringb.append(" HTML").append(" CSS");
				System.out.println(stringb);
				System.out.println(stringb.reverse());
				
				//->StringBuilder: 비동기 기능이 추가되어있기 때문에, 더 효율적이고 좋음
				//StringBuffer와 같은 메서드 사용
				
				StringTokenizer ymd = new StringTokenizer("2022-3-13", "-");
				int token = ymd.countTokens();
				System.out.println(token);
				
				//split은 지정 문자열을 기준으로, 배열로 나누어줌.
				
				String ymd2 = "200-22-22";
				String[] fe = ymd2.split("-");
				
				for (String string : fe) {
					System.out.println(string);;
				}
	}
}
