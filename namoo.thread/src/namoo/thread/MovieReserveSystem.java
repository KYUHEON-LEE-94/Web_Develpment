package namoo.thread;

/** 멀티스레드에 의해 공유되는 클래스 */
public class MovieReserveSystem {

	private boolean[] tickets; //예매가된 곳은 true 안된곳은 false

	public MovieReserveSystem() {
		this(10);
	}

	public MovieReserveSystem(int count) {
		tickets = new boolean[count];
	}

	// 스레드에 의해 호출되는 예약 메소드
	public  /*synchronized*/ boolean reserve(Member member) {
		System.out.println("----- reserve() Method Start -----");
		System.out.println(member.getUserName() + "님 예약 신청!!!");
		// 데이터베이스 서버를 체크 한다는 의미로 1초 동안 대기
		try {
			System.out.println(member.getUserName() + "님 예약 진행중 >>>>>");
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (tickets) {
			
			for (int i = 0; i < tickets.length; i++) {
				// 예약되어 있지 않았으면
				if (!tickets[i]) {
					// 예약으로 변경
					tickets[i] = true;
					System.out.println(member.getUserName() + "님 " + (i + 1) + "번 좌석 예약 완료 >>>>>");
					return tickets[i];
				}
			}
		}
		
		System.out.println("----- reserve() Method End -----");
		// 좌석이 없으면
		return false;
	}

}
