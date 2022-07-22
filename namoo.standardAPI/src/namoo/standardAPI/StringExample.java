package namoo.standardAPI;

public class StringExample {
	public static void main(String[] args) {
		String name = "이규헌";
		String name2 = "이규헌";
		
		System.out.println(name.equals(name2));
		System.out.println(name == name2);
		
		//------------------------------------
		
		String name3 = new String("JAVA");
		String name4 = new String("JAVA");
		
		System.out.println(name3.equals(name4));
		System.out.println(name3 == name4);
		
		
		//주요 메소드
		String lecture = "Java HTML CSS JavaScript SQL";
		System.out.println(lecture.substring(5,9));
		System.out.println(lecture.length());
		
		System.out.println(lecture.substring(5,9)+ name);
		lecture.concat("안녕").concat("왓더");
		
		System.out.println(lecture.replace("Java", "자바"));

		String ssn = "184585-48318858";
			
		char c = ssn.charAt(ssn.indexOf("-")+1);
		
		switch (c) {
		case '1': System.out.println("남자"); break;
		case '2': System.out.println("여자"); break;
		case '3': System.out.println("남자"); break;
		case '4': System.out.println("여자"); break;
		default: System.out.println("외국인"); break;
		
		}
		
		String message = "         avs                ";
		System.out.println(message.trim());
		
		int number3 = 12345;
		String.valueOf(number3).length();
		
		
		
		StringBuilder sb = new StringBuilder("JAVA");
		System.out.println(sb.append(true).append(10).append("Last"));
		System.out.println(sb.reverse());
		System.out.println(sb.insert(3, "what"));
		
		
		
	}
}
