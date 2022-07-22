package namoo.standardAPI;

public class RegularExpressionExample {
	public static void main(String[] args) {
		String userId = "dumbalom009";
		String password = "asdf!@#$";

		String userIdRegex = "^[a-zA-Z0-9]{8,20}$";
		String passwordRegex = "^[a-zA-Z0-9!@#$]{8,20}$";

		boolean userIdResult = userId.matches(userIdRegex);
		boolean passwordResult = password.matches(passwordRegex);

		System.out.println(userIdResult ? "일치" : "불일치");
		System.out.println(passwordResult ? "일치" : "불일치");
	}
}
