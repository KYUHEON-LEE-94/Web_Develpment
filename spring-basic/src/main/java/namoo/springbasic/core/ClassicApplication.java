package namoo.springbasic.core;

public class ClassicApplication {

	public static void main(String[] args) {	
		//느슨한 결합을 위해 Marine에서 Weapon을 생성하지 않고, application에서 관계를 맺어줌
		Weapon weapon = new Gun();
		Unit marine = new Marine("마린",2,weapon);
		marine.offense();
		marine.defense();

		//그러나 Main은 프로그램을 실행하고 끝내는 역할이지, 여기서 객체의 생성과 관계를 맺어주는 역할이 아님
			//클래스들간의 생성 및 연관을 맺어준 역할을 한것 -> serviceFactory 메서드였고, 그 메서드를 사용한게 Controller클래스였음
				// -> 여기서 더 나아가는게 Spring

	}

}
