package namoo.thread;

public class Member extends Thread {

	private String userName;
	// 스레드 공유 객체

	private MovieReserveSystem reserveSystem;

	public Member(String userName, MovieReserveSystem reserveSystem) {
		this.userName = userName;
		this.reserveSystem = reserveSystem;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void run() {
		reserveSystem.reserve(this);
	}
}
