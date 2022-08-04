package namoo.thread;

/** 스레드 테스트를 위한 애플리케이션 클래스 */
public class ReserveExample {

	public static void main(String[] args) {
		
		// 스레드에 의해 공유되는 객체 생성
		MovieReserveSystem reserveSystem = new MovieReserveSystem(10);
		// 테스트를 위한 회원 스레드 생성 및 실행
		Member m1 = new Member("찬호", reserveSystem);
		Member m2 = new Member("지성", reserveSystem);
		Member m3 = new Member("승엽", reserveSystem);
		m1.start();
		m2.start();
		m3.start();

	}

}
