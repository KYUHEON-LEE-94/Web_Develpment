package namoo.standardAPI;

public class MathExample {
	public static void main(String[] args) {

		System.out.println("2의 3승 값: " + Math.pow(2, 3));
		System.out.println("69.6의 반올림: " + Math.round(69.6));
		System.out.println("69.3의 절상: " + Math.ceil(69.3));
		System.out.println("69.8의 절하: " + Math.floor(69.8));
		// 임의값 (0.0 <= random < 1.0)
		System.out.println(Math.random());
		// 0 ~ 10 범위의 임의의 값
		System.out.println((int) (Math.random() * 10));
		// 로또 번호 (1 ~ 45범위의 6개)
		for (int i = 0; i < 6; i++) {
			System.out.print((int) (Math.random() * 45) + 1 + "\t");
		}

	}
}
